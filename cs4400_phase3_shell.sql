-- CS4400: Introduction to Database Systems
-- Bank Management Project - Phase 3 (v2)
-- Generating Stored Procedures & Functions for the Use Cases
-- April 4th, 2022

-- implement these functions and stored procedures on the project database
use bank_management;

-- [1] create_corporation()
-- This stored procedure creates a new corporation
drop procedure if exists create_corporation;
delimiter //
create procedure create_corporation (in ip_corpID varchar(100),
    in ip_shortName varchar(100), in ip_longName varchar(100),
    in ip_resAssets integer)
sp_1: begin
	insert into corporation values (ip_corpID, ip_shortName, ip_longName, ip_resAssets);
end //
delimiter ;

-- [2] create_bank()
-- This stored procedure creates a new bank that is owned by an existing corporation
-- The corporation must also be managed by a valid employee [being a manager doesn't leave enough time for other jobs]
drop procedure if exists create_bank;
delimiter //
create procedure create_bank (in ip_bankID varchar(100), in ip_bankName varchar(100),
	in ip_street varchar(100), in ip_city varchar(100), in ip_state char(2),
    in ip_zip char(5), in ip_resAssets integer, in ip_corpID varchar(100),
    in ip_manager varchar(100), in ip_bank_employee varchar(100))
sp_2: begin
	if ip_corpID not in (select corpID from corporation) then leave sp_2; end if;
	if ip_manager not in (select perID from employee) then leave sp_2; end if;
	if ip_manager in (select perID from workFor) then leave sp_2; end if;
    insert into bank values (ip_bankID, ip_bankName, ip_street, ip_city, ip_state, ip_zip, ip_resAssets, ip_corpID, ip_manager);
	insert into workFor values (ip_bankID, ip_bank_employee);
end //
delimiter ;

-- [3] start_employee_role()
-- If the person exists as an admin or employee then don't change the database state [not allowed to be admin along with any other person-based role]
-- If the person doesn't exist then this stored procedure creates a new employee
-- If the person exists as a customer then the employee data is added to create the joint customer-employee role
drop procedure if exists start_employee_role;
delimiter //
create procedure start_employee_role (in ip_perID varchar(100), in ip_taxID char(11),
	in ip_firstName varchar(100), in ip_lastName varchar(100), in ip_birthdate date,
    in ip_street varchar(100), in ip_city varchar(100), in ip_state char(2),
    in ip_zip char(5), in ip_dtJoined date, in ip_salary integer,
    in ip_payments integer, in ip_earned integer, in emp_password  varchar(100))
sp_3: begin
	if ip_perID in (select perID from system_admin) then leave sp_3; end if;
	if ip_perID in (select perID from employee) then leave sp_3; end if;
	if ip_perID not in (select perID from person) then
	insert into person values (ip_perID, emp_password);
	insert into bank_user values (ip_perID, ip_taxID, ip_birthdate, ip_firstName, ip_lastName, ip_dtJoined, ip_street, ip_city, ip_state, ip_zip);
    end if;
	insert into employee values (ip_perID, ip_salary, ip_payments, ip_earned);
end //
delimiter ;

-- [4] start_customer_role()
-- If the person exists as an admin or customer then don't change the database state [not allowed to be admin along with any other person-based role]
-- If the person doesn't exist then this stored procedure creates a new customer
-- If the person exists as an employee then the customer data is added to create the joint customer-employee role
drop procedure if exists start_customer_role;
delimiter //
create procedure start_customer_role (in ip_perID varchar(100), in ip_taxID char(11),
	in ip_firstName varchar(100), in ip_lastName varchar(100), in ip_birthdate date,
    in ip_street varchar(100), in ip_city varchar(100), in ip_state char(2),
    in ip_zip char(5), in ip_dtJoined date, in cust_password varchar(100))
sp_4: begin
	if ip_perID in (select perID from system_admin) then leave sp_4; end if;
	if ip_perID in (select perID from customer) then leave sp_4; end if;
	if ip_perID not in (select perID from person) then
	insert into person values (ip_perID, cust_password);
	insert into bank_user values (ip_perID, ip_taxID, ip_birthdate, ip_firstName, ip_lastName, ip_dtJoined, ip_street, ip_city, ip_state, ip_zip);
	end if;
	insert into customer values (ip_perID);
end //
delimiter ;

-- [5] stop_employee_role()
-- If the person doesn't exist as an employee then don't change the database state
-- If the employee manages a bank or is the last employee at a bank then don't change the database state [each bank must have a manager and at least one employee]
-- If the person exists in the joint customer-employee role then the employee data must be removed, but the customer information must be maintained
-- If the person exists only as an employee then all related person data must be removed
drop procedure if exists stop_employee_role;
delimiter //
create procedure stop_employee_role (in ip_perID varchar(100))
sp_5: begin
	if ip_perID not in (select perID from employee) then leave sp_5; end if;
	if ip_perID in (select manager from bank) then leave sp_5; end if;
	if ip_perID in (select w1.perID
					from workFor as w1
					where w1.bankID in (select w2.bankID from workFor as w2 group by w2.bankID having count(*) = 1)) then leave sp_5; end if;
	delete from workFor where ip_perID = perID;
	delete from employee where ip_perID = perID;
	if ip_perID not in (select perID from customer) then
	delete from bank_user where ip_perID = perID;
	delete from person where ip_perID = perID;
end if;
end //
delimiter ;

-- [6] stop_customer_role()
-- If the person doesn't exist as an customer then don't change the database state
-- If the customer is the only holder of an account then don't change the database state [each account must have at least one holder]
-- If the person exists in the joint customer-employee role then the customer data must be removed, but the employee information must be maintained
-- If the person exists only as a customer then all related person data must be removed
drop procedure if exists stop_customer_role;
delimiter //
create procedure stop_customer_role (in ip_perID varchar(100))
sp_6: begin
	if ip_perID not in (select perID from customer) then leave sp_6; end if;
	if ip_perID in (select perID
					from access as a1
					where (a1.bankID, a1.accountID) in (select a2.bankID, a2.accountID from access as a2 group by a2.bankID, a2.accountID having count(*) = 1)) then leave sp_6; end if;
	delete from access where ip_perID = perID;
	delete from customer_contacts where ip_perID = perID;
	delete from customer where ip_perID = perID;
	if ip_perID not in (select perID from employee) then
	delete from bank_user where ip_perID = perID;
	delete from person where ip_perID = perID;
	end if;
end //
delimiter ;

-- [7] hire_worker()
-- If the person is not an employee then don't change the database state
-- If the worker is a manager then then don't change the database state [being a manager doesn't leave enough time for other jobs]
-- Otherwise, the person will now work at the assigned bank in addition to any other previous work assignments
-- Also, adjust the employee's salary appropriately
drop procedure if exists hire_worker;
delimiter //
create procedure hire_worker (in ip_perID varchar(100), in ip_bankID varchar(100),
	in ip_salary integer)
sp_7: begin
	if ip_perID not in (select perID from employee) then leave sp_7; end if;
	if ip_perID in (select manager from bank) then leave sp_7; end if;
    if ip_salary < 0 then leave sp_7; end if;
	insert into workFor values (ip_bankID, ip_perID);
	update employee set salary = ip_salary where perID = ip_perID;
end //
delimiter ;

-- [8] replace_manager()
-- If the new person is not an employee then don't change the database state
-- If the new person is a manager or worker at any bank then don't change the database state [being a manager doesn't leave enough time for other jobs]
-- Otherwise, replace the previous manager at that bank with the new person
-- The previous manager's association as manager of that bank must be removed
-- Adjust the employee's salary appropriately
drop procedure if exists replace_manager;
delimiter //
create procedure replace_manager (in ip_perID varchar(100), in ip_bankID varchar(100),
	in ip_salary integer)
sp_8: begin
	if ip_perID not in (select perID from employee) then leave sp_8; end if;
	if ip_perID in (select manager from bank) then leave sp_8; end if;
	if ip_perID in (select perID from workFor) then leave sp_8; end if;
    if ip_salary < 0 then leave sp_8; end if;
	update bank set manager = ip_perID where bankID = ip_bankID;
	update employee set salary = ip_salary where perID = ip_perID;
end //
delimiter ;

-- [9] add_account_access()
-- If the account does not exist, create a new account. If the account exists, add the customer to the account
-- When creating a new account:
    -- If the person opening the account is not an admin then don't change the database state
    -- If the intended customer (i.e. ip_customer) is not a customer then don't change the database state
    -- Otherwise, create a new account owned by the designated customer
    -- The account type will be determined by the enumerated ip_account_type variable
    -- ip_account_type in {checking, savings, market}
-- When adding a customer to an account:
    -- If the person granting access is not an admin or someone with access to the account then don't change the database state
    -- If the intended customer (i.e. ip_customer) is not a customer then don't change the database state
    -- Otherwise, add the new customer to the existing account
drop procedure if exists add_account_access;
delimiter //
create procedure add_account_access (in ip_requester varchar(100), in ip_customer varchar(100),
	in ip_account_type varchar(10), in ip_bankID varchar(100),
    in ip_accountID varchar(100), in ip_balance integer, in ip_interest_rate integer,
    in ip_dtDeposit date, in ip_minBalance integer, in ip_numWithdrawals integer,
    in ip_maxWithdrawals integer, in ip_dtShareStart date)
sp_9: begin
	if (ip_bankID, ip_accountID) not in (select bankID, accountID from bank_account) then 
	if ip_requester not in (select perID from system_admin) then leave sp_9; end if;
	if ip_customer not in (select perID from customer) then leave sp_9; end if;
	insert into bank_account values (ip_bankID, ip_accountID, ip_balance);
	if ip_account_type = 'checking' then
	insert into checking (bankID, accountID) values (ip_bankID, ip_accountID);
	end if;
	if ip_account_type = 'savings' then
	insert into interest_bearing values (ip_bankID, ip_accountID, ip_interest_rate, ip_dtDeposit);
	insert into savings values (ip_bankID, ip_accountID, ip_minBalance);
	end if;
	if ip_account_type = 'market' then
	insert into interest_bearing values (ip_bankID, ip_accountID, ip_interest_rate, ip_dtDeposit);
	insert into market values (ip_bankID, ip_accountID, ip_maxWithdrawals, ip_numWithdrawals);
	end if;
	insert into access (perID, bankID, accountID, dtShareStart) values (ip_customer, ip_bankID, ip_accountID, ip_dtShareStart);
	leave sp_9;
	end if;
	if (ip_bankID, ip_accountID) in (select bankID, accountID from bank_account) then
	if ip_requester not in (select perID from system_admin) then
	if (ip_requester, ip_bankID, ip_accountID) not in (select perID, bankID, accountID from access) then leave sp_9; end if;
    end if;
	if ip_customer not in (select perID from customer) then leave sp_9; end if;
	insert into access (perID, bankID, accountID, dtShareStart) values (ip_customer, ip_bankID, ip_accountID, ip_dtShareStart);
	end if;
end //
delimiter ;

-- [10] remove_account_access()
-- Remove a customer's account access. If they are the last customer with access to the account, close the account
-- When just revoking access:
    -- If the person revoking access is not an admin or someone with access to the account then don't change the database state
    -- Otherwise, remove the designated sharer from the existing account
-- When closing the account:
    -- If the customer to be removed from the account is NOT the last remaining owner/sharer then don't close the account
    -- If the person closing the account is not an admin or someone with access to the account then don't change the database state
    -- Otherwise, the account must be closed
drop procedure if exists remove_account_access;
delimiter //
create procedure remove_account_access (in ip_requester varchar(100), in ip_sharer varchar(100),
	in ip_bankID varchar(100), in ip_accountID varchar(100))
sp_10: begin
	if ip_requester not in (select perID from system_admin) then
	if (ip_requester, ip_bankID, ip_accountID) not in (select perID, bankID, accountID from access) then leave sp_10; end if;
    end if;
    if (ip_sharer, ip_bankID, ip_accountID) not in (select perID, bankID, accountID from access) then leave sp_10; end if;
	if (select count(*) from access where (ip_bankID, ip_accountID) = (bankID, accountID)) = 1 then
	delete from access where (ip_bankID, ip_accountID) = (bankID, accountID);
	delete from checking where (ip_bankID, ip_accountID) = (bankID, accountID);
    if (ip_bankID, ip_accountID) in (select protectionBank, protectionAccount from checking) then
	update checking set protectionBank = NULL where (ip_bankID, ip_accountID) = (protectionBank, protectionAccount);
	update checking set protectionAccount = NULL where protectionBank is NULL and ip_accountID = protectionAccount;
    end if;
	delete from savings where (ip_bankID, ip_accountID) = (bankID, accountID);
	delete from market where (ip_bankID, ip_accountID) = (bankID, accountID);
	delete from interest_bearing_fees where (ip_bankID, ip_accountID) = (bankID, accountID);
	delete from interest_bearing where (ip_bankID, ip_accountID) = (bankID, accountID);
	delete from bank_account where (ip_bankID, ip_accountID) = (bankID, accountID);
	leave sp_10;
	end if;
	delete from access where (ip_sharer, ip_bankID, ip_accountID) = (perID, bankID, accountID);
end //
delimiter ;

-- [11] create_fee()
drop procedure if exists create_fee;
delimiter //
create procedure create_fee (in ip_bankID varchar(100), in ip_accountID varchar(100),
	in ip_fee_type varchar(100))
sp_11 : begin
	if (ip_bankID, ip_accountID) not in (select bankID, accountID from interest_bearing) then leave sp_11; end if;
	insert into interest_bearing_fees values (ip_bankID, ip_accountID, ip_fee_type);
end //
delimiter ;

-- [12] start_overdraft()
drop procedure if exists start_overdraft;
delimiter //
create procedure start_overdraft (in ip_requester varchar(100),
	in ip_checking_bankID varchar(100), in ip_checking_accountID varchar(100),
    in ip_savings_bankID varchar(100), in ip_savings_accountID varchar(100))
sp_12: begin
	if ip_requester not in (select perID from system_admin) then
	if (ip_requester, ip_checking_bankID, ip_checking_accountID) not in (select perID, bankID, accountID from access) then leave sp_12; end if;
 	if (ip_requester, ip_savings_bankID, ip_savings_accountID) not in (select perID, bankID, accountID from access) then leave sp_12; end if;
    end if;
 	if (ip_savings_bankID, ip_savings_accountID) in (select protectionBank, protectionAccount from checking) then leave sp_12; end if;
 	if (select protectionBank, protectionAccount from checking where (ip_checking_bankID, ip_checking_accountID) = (bankID, accountID)) != (NULL, NULL) then leave sp_12; end if;
    if (ip_checking_bankID, ip_checking_accountID) not in (select bankID, accountID from checking) then leave sp_12; end if;
    if (ip_savings_bankID, ip_savings_accountID) not in (select bankID, accountID from savings) then leave sp_12; end if;
	update checking set protectionBank = ip_savings_bankID where (ip_checking_bankID, ip_checking_accountID) = (bankID, accountID);
    update checking set protectionAccount = ip_savings_accountID where (ip_checking_bankID, ip_checking_accountID) = (bankID, accountID);
end //
delimiter ;

-- [13] stop_overdraft()
drop procedure if exists stop_overdraft;
delimiter //
create procedure stop_overdraft (in ip_requester varchar(100),
	in ip_checking_bankID varchar(100), in ip_checking_accountID varchar(100))
sp_13: begin
	if ip_requester not in (select perID from system_admin) then
	if (ip_requester, ip_checking_bankID, ip_checking_accountID) not in (select perID, bankID, accountID from access) then leave sp_13; end if;
	end if;
    update checking set protectionBank = NULL where (ip_checking_bankID, ip_checking_accountID) = (bankID, accountID);
	update checking set protectionAccount = NULL where (ip_checking_bankID, ip_checking_accountID) = (bankID, accountID);
end //
delimiter ;

-- [14] account_deposit()
-- If the person making the deposit does not have access to the account then don't change the database state
-- Otherwise, the account balance and related info must be modified appropriately
drop procedure if exists account_deposit;
delimiter //
create procedure account_deposit (in ip_requester varchar(100), in ip_deposit_amount integer,
	in ip_bankID varchar(100), in ip_accountID varchar(100), in ip_dtAction date)
sp_14: begin
	if (ip_requester, ip_bankID, ip_accountID) not in (select perID, bankID, accountID from access) then leave sp_14; end if;
    if ip_deposit_amount <= 0 then leave sp_14; end if;
    update bank_account set balance = balance + ip_deposit_amount where (ip_bankID, ip_accountID) = (bankID, accountID);
    update bank_account set balance = ip_deposit_amount where (ip_bankID, ip_accountID) = (bankID, accountID) and balance is NULL;
    update access set dtAction = ip_dtAction where (ip_requester, ip_bankID, ip_accountID) = (perID, bankID, accountID);
	if (ip_bankID, ip_accountID) in (select bankID, accountID from interest_bearing) then
	update interest_bearing set dtDeposit = ip_dtAction where (ip_bankID, ip_accountID) = (bankID, accountID);
	end if;
end //
delimiter ;

-- [15] account_withdrawal()
-- If the person making the withdrawal does not have access to the account then don't change the database state
-- If the withdrawal amount is more than the account balance for a savings or market account then don't change the database state [the account balance must be positive]
-- If the withdrawal amount is more than the account balance + the overdraft balance (i.e., from the designated savings account) for a checking account then don't change the database state [the account balance must be positive]
-- Otherwise, the account balance and related info must be modified appropriately (amount deducted from the primary account first, and second from the overdraft account as needed)
drop procedure if exists account_withdrawal;
delimiter //
create procedure account_withdrawal (in ip_requester varchar(100), in ip_withdrawal_amount integer,
	in ip_bankID varchar(100), in ip_accountID varchar(100), in ip_dtAction date)
sp_15: begin
	drop table if exists t1;
	create table t1 as
    select c.bankID as cBank, c.accountID as cAccount, b1.balance as cBalance, c.protectionBank as sBank, c.protectionAccount as sAccount, b2.balance as sBalance
    from checking as c
    join bank_account as b1 on (c.bankID, c.accountID) = (b1.bankID, b1.accountID)
    join bank_account as b2 on (c.protectionBank, c.protectionAccount) = (b2.bankID, b2.accountID)
    where (c.bankID, c.accountID) = (ip_bankID, ip_accountID);
	if (ip_requester, ip_bankID, ip_accountID) not in (select perID, bankID, accountID from access) then leave sp_15; end if;
    if ip_withdrawal_amount <= 0 then leave sp_15; end if;
	if ip_withdrawal_amount <= (select balance from bank_account where (bankID, accountID) = (ip_bankID, ip_accountID)) then
	update bank_account set balance = balance - ip_withdrawal_amount where (ip_bankID, ip_accountID) = (bankID, accountID);
	update access set dtAction = ip_dtAction where (ip_requester, ip_bankID, ip_accountID) = (perID, bankID, accountID);
    if (ip_bankID, ip_accountID) in (select bankID, accountID from market) then
	update market set numWithdrawals = numWithdrawals + 1 where (ip_bankID, ip_accountID) = (bankID, accountID);
	end if;
	leave sp_15;
	end if;
	if ip_withdrawal_amount > (select balance from bank_account where (bankID, accountID) = (ip_bankID, ip_accountID)) then
	if (ip_bankID, ip_accountID) not in (select cBank, cAccount from t1) then leave sp_15; end if;
	if ip_withdrawal_amount > (select cBalance + sBalance from t1) then leave sp_15; end if;
	update bank_account set balance = 0 where (ip_bankID, ip_accountID) = (bankID, accountID);
	update bank_account set balance = balance - ip_withdrawal_amount + (select cBalance from t1) where (select sBank, sAccount from t1) = (bankID, accountID);
	update checking set amount = ip_withdrawal_amount - (select cBalance from t1) where (ip_bankID, ip_accountID) = (bankID, accountID);
	update checking set dtOverdraft = ip_dtAction where (ip_bankID, ip_accountID) = (bankID, accountID);
	update access set dtAction = ip_dtAction where (ip_requester, ip_bankID, ip_accountID) = (perID, bankID, accountID);
    update access set dtAction = ip_dtAction where ip_requester = perID and (select sBank, sAccount from t1) = (bankID, accountID);
    if (ip_bankID, ip_accountID) in (select bankID, accountID from market) then
	update market set numWithdrawals = numWithdrawals + 1 where (ip_bankID, ip_accountID) = (bankID, accountID);
	end if;
	end if;
end //
delimiter ;

-- [16] account_transfer()
-- If the person making the transfer does not have access to both accounts then don't change the database state
-- If the withdrawal amount is more than the account balance for a savings or market account then don't change the database state [the account balance must be positive]
-- If the withdrawal amount is more than the account balance + the overdraft balance (i.e., from the designated savings account) for a checking account then don't change the database state [the account balance must be positive]
-- Otherwise, the account balance and related info must be modified appropriately (amount deducted from the withdrawal account first, and second from the overdraft account as needed, and then added to the deposit account)
drop procedure if exists account_transfer;
delimiter //
create procedure account_transfer (in ip_requester varchar(100), in ip_transfer_amount integer,
	in ip_from_bankID varchar(100), in ip_from_accountID varchar(100),
    in ip_to_bankID varchar(100), in ip_to_accountID varchar(100), in ip_dtAction date)
sp_16: begin
	drop table if exists t2;
	create table t2 as
    select c.bankID as cBank, c.accountID as cAccount, b1.balance as cBalance, c.protectionBank as sBank, c.protectionAccount as sAccount, b2.balance as sBalance
    from checking as c
    join bank_account as b1 on (c.bankID, c.accountID) = (b1.bankID, b1.accountID)
    join bank_account as b2 on (c.protectionBank, c.protectionAccount) = (b2.bankID, b2.accountID)
    where (c.bankID, c.accountID) = (ip_from_bankID, ip_from_accountID);
	if (ip_requester, ip_from_bankID, ip_from_accountID) not in (select perID, bankID, accountID from access) then leave sp_16; end if;
    if (ip_requester, ip_to_bankID, ip_to_accountID) not in (select perID, bankID, accountID from access) then leave sp_16; end if;
    if ip_transfer_amount <= 0 then leave sp_16; end if;
	if ip_transfer_amount <= (select balance from bank_account where (bankID, accountID) = (ip_from_bankID, ip_from_accountID)) then
	update bank_account set balance = balance - ip_transfer_amount where (ip_from_bankID, ip_from_accountID) = (bankID, accountID);
	update access set dtAction = ip_dtAction where (ip_requester, ip_from_bankID, ip_from_accountID) = (perID, bankID, accountID);
    update bank_account set balance = balance + ip_transfer_amount where (ip_to_bankID, ip_to_accountID) = (bankID, accountID);
    update bank_account set balance = ip_transfer_amount where (ip_to_bankID, ip_to_accountID) = (bankID, accountID) and balance is NULL;
	update access set dtAction = ip_dtAction where (ip_requester, ip_to_bankID, ip_to_accountID) = (perID, bankID, accountID);
    if (ip_from_bankID, ip_from_accountID) in (select bankID, accountID from market) then
	update market set numWithdrawals = numWithdrawals + 1 where (ip_from_bankID, ip_from_accountID) = (bankID, accountID);
	end if;
	if (ip_to_bankID, ip_to_accountID) in (select bankID, accountID from interest_bearing) then
	update interest_bearing set dtDeposit = ip_dtAction where (ip_to_bankID, ip_to_accountID) = (bankID, accountID);
	end if;
	leave sp_16;
	end if;
	if ip_transfer_amount > (select balance from bank_account where (bankID, accountID) = (ip_from_bankID, ip_from_accountID)) then
	if (ip_from_bankID, ip_from_accountID) not in (select cBank, cAccount from t2) then leave sp_16; end if;
	if ip_transfer_amount > (select cBalance + sBalance from t2) then leave sp_16; end if;
	update bank_account set balance = 0 where (ip_from_bankID, ip_from_accountID) = (bankID, accountID);
	update bank_account set balance = balance - ip_transfer_amount + (select cBalance from t2) where (select sBank, sAccount from t2) = (bankID, accountID);
	update checking set amount = ip_transfer_amount - (select cBalance from t2) where (ip_from_bankID, ip_from_accountID) = (bankID, accountID);
	update checking set dtOverdraft = ip_dtAction where (ip_from_bankID, ip_from_accountID) = (bankID, accountID);
	update access set dtAction = ip_dtAction where (ip_requester, ip_from_bankID, ip_from_accountID) = (perID, bankID, accountID);
    update access set dtAction = ip_dtAction where ip_requester = perID and (select sBank, sAccount from t2) = (bankID, accountID);
    update bank_account set balance = balance + ip_transfer_amount where (ip_to_bankID, ip_to_accountID) = (bankID, accountID);
    update bank_account set balance = ip_transfer_amount where (ip_to_bankID, ip_to_accountID) = (bankID, accountID) and balance is NULL;
	update access set dtAction = ip_dtAction where (ip_requester, ip_to_bankID, ip_to_accountID) = (perID, bankID, accountID);
	if (ip_from_bankID, ip_from_accountID) in (select bankID, accountID from market) then
	update market set numWithdrawals = numWithdrawals + 1 where (ip_from_bankID, ip_from_accountID) = (bankID, accountID);
	end if;
    if (ip_to_bankID, ip_to_accountID) in (select bankID, accountID from interest_bearing) then
	update interest_bearing set dtDeposit = ip_dtAction where (ip_to_bankID, ip_to_accountID) = (bankID, accountID);
	end if;
	end if;
end //
delimiter ;

-- [17] pay_employees()
-- Increase each employee's pay earned so far by the monthly salary
-- Deduct the employee's pay from the banks reserved assets
-- If an employee works at more than one bank, then deduct the (evenly divided) monthly pay from each of the affected bank's reserved assets
-- Truncate any fractional results to an integer before further calculations
drop procedure if exists pay_employees;
delimiter //
create procedure pay_employees ()
sp_17: begin
    drop table if exists t3;
    create table t3 as
    select perID, truncate(salary / count(*), 0) as dividedSalary
	from workFor natural join employee
	group by perID;
    drop table if exists t4;
    create table t4 as
    select bankID, sum(dividedSalary) as deducted
    from workFor natural join t3
    group by bankID;
    update employee set payments = 0 where payments is NULL;
    update bank set resAssets = 0 where resAssets is NULL;
    update employee set earned = earned + salary where salary is not NULL;
    update employee set payments = payments + 1;
    update bank as b set resAssets = resAssets - (select deducted from t4 as t where t.bankID = b.bankID) where bankID in (select bankID from t4);
end //
delimiter ;

-- [18] penalize_accounts()
-- For each savings account that is below the minimum balance, deduct the smaller of $100 or 10% of the current balance from the account
-- For each market account that has exceeded the maximum number of withdrawals, deduct the smaller of $500 per excess withdrawal or 20% of the current balance from the account
-- Add all deducted amounts to the reserved assets of the bank that owns the account
-- Truncate any fractional results to an integer before further calculations
drop procedure if exists penalize_accounts;
delimiter //
create procedure penalize_accounts ()
sp_18: begin
	drop table if exists bad_savings1;
	create table bad_savings1 as
	select bankID, accountID, least(100, truncate(0.1 * balance, 0)) as decrease
	from savings natural join bank_account
	where balance < minBalance;
    drop table if exists bad_savings2;
    create table bad_savings2 as
    select bankID, sum(decrease) as increase
    from bad_savings1
    where decrease is not NULL
    group by bankID;
    drop table if exists bad_market1;
	create table bad_market1 as
	select bankID, accountID, least(500 * (numWithdrawals - maxWithdrawals), truncate(0.2 * balance, 0)) as decrease
	from market natural join bank_account
	where numWithdrawals > maxWithdrawals;
    drop table if exists bad_market2;
    create table bad_market2 as
    select bankID, sum(decrease) as increase
    from bad_market1
    where decrease is not NULL
    group by bankID;
    update bank set resAssets = 0 where resAssets is NULL;
	update bank_account as b set balance = balance - (select decrease from bad_savings1 where (bankID, accountID) = (b.bankID, b.accountID)) where (bankID, accountID) in (select bankID, accountID from bad_savings1);
	update bank as b set resAssets = resAssets + (select increase from bad_savings2 where bankID = b.bankID) where bankID in (select bankID from bad_savings2);
	update bank_account as b set balance = balance - (select decrease from bad_market1 where (bankID, accountID) = (b.bankID, b.accountID)) where (bankID, accountID) in (select bankID, accountID from bad_market1);
	update bank as b set resAssets = resAssets + (select increase from bad_market2 where bankID = b.bankID) where bankID in (select bankID from bad_market2);
end //
delimiter ;

-- [19] accrue_interest()
-- For each interest-bearing account that is "in good standing", increase the balance based on the designated interest rate
-- A savings account is "in good standing" if the current balance is equal to or above the designated minimum balance
-- A market account is "in good standing" if the current number of withdrawals is less than or equal to the maximum number of allowed withdrawals
-- Subtract all paid amounts from the reserved assets of the bank that owns the account                                                                       
-- Truncate any fractional results to an integer before further calculations
drop procedure if exists accrue_interest;
delimiter //
create procedure accrue_interest ()
sp__19: begin
	drop table if exists good_savings1;
	create table good_savings1 as
	select bankID, accountID, truncate(balance * (interest_rate/100), 0) as increase
	from savings natural join bank_account natural join interest_bearing
	where interest_rate is not NULL and (balance >= minBalance or (balance is NULL and minBalance is NULL));
    drop table if exists good_savings2;
    create table good_savings2 as
    select bankID, sum(increase) as decrease
    from good_savings1
    where increase is not NULL
    group by bankID;
    drop table if exists good_market1;
	create table good_market1 as
	select bankID, accountID, truncate(balance * (interest_rate/100), 0) as increase
	from market natural join bank_account natural join interest_bearing
	where interest_rate is not NULL and (numWithdrawals <= maxWithdrawals or (numWithdrawals is NULL and maxWithdrawals is NULL));
    drop table if exists good_market2;
    create table good_market2 as
    select bankID, sum(increase) as decrease
    from good_market1
    where increase is not NULL
    group by bankID;
    update bank set resAssets = 0 where resAssets is NULL;
	update bank_account as b set balance = balance + (select increase from good_savings1 where (bankID, accountID) = (b.bankID, b.accountID)) where (bankID, accountID) in (select bankID, accountID from good_savings1);
	update bank as b set resAssets = resAssets - (select decrease from good_savings2 where bankID = b.bankID) where bankID in (select bankID from good_savings2);
	update bank_account as b set balance = balance + (select increase from good_market1 where (bankID, accountID) = (b.bankID, b.accountID)) where (bankID, accountID) in (select bankID, accountID from good_market1);
	update bank as b set resAssets = resAssets - (select decrease from good_market2 where bankID = b.bankID) where bankID in (select bankID from good_market2);
end //
delimiter ;

-- [20] display_account_stats()
-- Display the simple and derived attributes for each account, along with the owning bank
	create or replace view display_account_stats as 
	select bankName as name_of_bank, accountID as account_identifier, balance as account_assets, count(*) as number_of_owners
	from access natural left join bank_account natural left join bank
	group by bankID, accountID;

-- [21] display_bank_stats()
-- Display the simple and derived attributes for each bank, along with the owning corporation
	drop table if exists t5;
	create table t5 as
	select bankID, resAssets, balance
	from bank natural join bank_account;
	update t5 set resAssets = 0 where resAssets is NULL;
	update t5 set balance = 0 where balance is NULL;
	drop table if exists t6;
	create table t6 as
	select bankID, count(*) as number_of_accounts, resAssets + sum(balance) as total_assets
	from t5
	group by bankID, resAssets;
    drop table if exists t7;
    create table t7 as
    select *
    from bank as b natural left join t6;
    update t7 set total_assets = 0 where total_assets is NULL and resAssets is NULL;
    update t7 set total_assets = resAssets where total_assets is NULL;
	create or replace view display_bank_stats as
    select bankID as bank_identifier, shortName as name_of_corporation, bankName as name_of_bank, street, city, state, zip, number_of_accounts, t7.resAssets as bank_assets, total_assets
	from t7 left join corporation as c on t7.corpID = c.corpID;

-- [22] display_corporation_stats()
-- Display the simple and derived attributes for each corporation
	drop table if exists t8;
	create table t8 as
	select bankID, corpID, resAssets, balance
	from bank natural left join bank_account;
	update t8 set resAssets = 0 where resAssets is NULL;
	update t8 set balance = 0 where balance is NULL;
	drop table if exists t9;
	create table t9 as
	select bankID, corpID, resAssets + sum(balance) as assets
	from t8
	group by bankID, corpID, resAssets;
    drop table if exists t10;
    create table t10 as
	select corpID, count(*) as number_of_banks, resAssets + sum(assets) as total_assets
	from corporation natural join t9
    group by corpID, resAssets;
    drop table if exists t11;
    create table t11 as
    select *
    from corporation natural left join t10;
    update t11 set total_assets = resAssets where total_assets is NULL;
	create or replace view display_corporation_stats as
    select corpID as corporation_identifier, shortName as short_name, longName as formal_name, number_of_banks, resAssets, total_assets
	from t11;

-- [23] display_customer_stats()
-- Display the simple and derived attributes for each customer
	drop table if exists t12;
	create table t12 as
	select perID, balance
	from access natural left join bank_account;
	update t12 set balance = 0 where balance is NULL;
    drop table if exists t13;
    create table t13 as
	select perID, count(*) as number_of_accounts, sum(balance) as customer_assets
	from t12
	group by perID;
    drop table if exists t14;
    create table t14 as
    select *
    from customer natural left join t13;
    update t14 set customer_assets = 0 where customer_assets is NULL;
    create or replace view display_customer_stats as
	select perID as person_identifier, taxID as tax_identifier, concat(firstName, " ", lastName) as customer_name, birthdate as date_of_birth, dtJoined as joined_system, street, city, state, zip, number_of_accounts, customer_assets
	from t14 natural left join bank_user;

-- [24] display_employee_stats()
-- Display the simple and derived attributes for each employee
	drop table if exists t15;
	create table t15 as
	select bankID, resAssets, balance
	from bank natural left join bank_account;
	update t15 set resAssets = 0 where resAssets is NULL;
	update t15 set balance = 0 where balance is NULL;
	drop table if exists t16;
	create table t16 as
	select bankID, resAssets + sum(balance) as assets
	from t15
	group by bankID, resAssets;
    drop table if exists t17;
    create table t17 as
	select perID, count(*) as number_of_banks, sum(assets) as bank_assets
	from workFor natural left join t16
	group by perID;
	create or replace view display_employee_stats as
    select perID as person_identifier, taxID as tax_identifier, concat(firstName, " ", lastName) as employee_name, birthdate as date_of_birth, dtJoined as joined_system, street, city, state, zip, number_of_banks, bank_assets
	from employee natural left join bank_user natural left join t17;
