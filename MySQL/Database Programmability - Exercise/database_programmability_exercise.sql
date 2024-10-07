# 01. Employees with Salary Above 35000
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN 
	SELECT `first_name`, `last_name` from `employees`
    WHERE `salary` > 35000
    ORDER BY `first_name`, `last_name`, `employee_id`;
END$$
DELIMITER ;

# 02. Employees with Salary Above Number
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(input DECIMAL(10,4))
BEGIN 
	SELECT `first_name`, `last_name` from `employees`
    WHERE `salary` >= input
    ORDER BY `first_name`, `last_name`, `employee_id`;
END$$
DELIMITER ;

# 03. Town Names Starting With
DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(input VARCHAR(50))
BEGIN
	SELECT `name` AS `town_name` FROM `towns`
    WHERE `name` LIKE CONCAT(input, '%')
    ORDER BY `town_name`;
END$$
DELIMITER ;

# 04. Employees from Town
DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(50))
BEGIN
	SELECT `first_name`, `last_name` FROM `employees` e
	JOIN `addresses` a USING (`address_id`)
    JOIN `towns` t USING (`town_id`)
    WHERE t.`name` = town_name
    ORDER BY e.`first_name`, e.`last_name`;
END$$
DELIMITER ;

# 05. Salary Level Function
DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary_input DECIMAL(19,4))
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
RETURN (
        SELECT (
			CASE
				WHEN salary_input < 30000 THEN 'Low'
				WHEN salary_input <= 50000 THEN 'Average'
				WHEN salary_input > 50000 THEN 'High'
			END) AS `salary_level`
	   );
END$$
DELIMITER ;

# 06. Employees by Salary Level
DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(`salary_level` VARCHAR(255))
BEGIN
    SELECT
        first_name,
        last_name
    FROM employees
    WHERE ufn_get_salary_level(salary) = salary_level
    ORDER BY first_name DESC, last_name DESC ;
END$$
DELIMITER ;

# 07.Define Function
DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(`set_of_letters` varchar(50), `word` varchar(50))
    RETURNS TINYINT
    DETERMINISTIC
BEGIN
    RETURN (
        SELECT word REGEXP CONCAT('^[', set_of_letters, ']+$')
    );
END
DELIMITER ;

# 08. Find Full Name
DELIMITER $$
CREATE PROCEDURE bank.usp_get_holders_full_name()
BEGIN
    SELECT
        concat_ws(' ', first_name, last_name) AS `full_name`
    FROM bank.account_holders
    ORDER BY full_name, id;
END$$
DELIMITER ; 

# 09. People with Balance Higher Than 
DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(`balance` DECIMAL(19,2))
BEGIN
    SELECT
        ah.`first_name`, ah.`last_name`
    FROM `account_holders` AS ah
             JOIN `accounts` AS a ON ah.`id` = a.`account_holder_id`
    GROUP BY  ah.`id`, ah.`first_name`, ah.`last_name`
    HAVING SUM(a.`balance`) > `balance`
    ORDER BY ah.`id`;
END$$
DELIMITER ;

# 10. Future Value Function
DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(`sum` DECIMAL(19, 4),`yearly_interest_rate` DECIMAL(19, 4),`number_of_years` INT)
    RETURNS DECIMAL(19, 4)
    DETERMINISTIC
BEGIN
    DECLARE future_value DECIMAL(19, 4);

    SET future_value = sum * POWER(1 + yearly_interest_rate, number_of_years);

    RETURN future_value;
END$$
DELIMITER ;

# 11. Calculating Interest
DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(`account_id` INT,`interest_rate` DECIMAL(19,4))
BEGIN
    SELECT
        a.`id` AS `account_id`,
        ah.`first_name`,
        ah.`last_name`,
        a.`balance` AS `current_balance`,
        ufn_calculate_future_value(a.`balance`, `interest_rate`, 5) AS `balance_in_5_years`
    FROM `account_holders` AS ah
        JOIN `accounts` AS a ON ah.`id` = a.`account_holder_id`
    WHERE a.`id` = `account_id`;
END$$
DELIMITER ;

# 12. Deposit Money
DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
    START TRANSACTION;
    IF ((SELECT COUNT(*) FROM accounts WHERE `id` = `account_id`) <> 1 OR `money_amount` < 0) THEN
        ROLLBACK;
    ELSE
        UPDATE `accounts` SET `balance` = `balance` + `money_amount` WHERE `id` = `account_id`;
        COMMIT;
    END IF;
END$$
DELIMITER ;

# 13. Withdraw Money
DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
    START TRANSACTION;
    IF ((SELECT COUNT(*) FROM accounts WHERE id = account_id) <> 1 OR money_amount < 0 OR (SELECT balance FROM accounts WHERE id = account_id) < money_amount) THEN
        ROLLBACK;
    ELSE
        UPDATE accounts SET balance = balance - money_amount WHERE id = account_id;
        COMMIT;
    END IF;
END$$
DELIMITER ;