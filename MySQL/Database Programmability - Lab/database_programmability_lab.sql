# 1. Count Employees by Town
DELIMITER $$
CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE result INT;
	SET result = (SELECT COUNT(*) AS 'count' FROM `employees` e
    JOIN `addresses` a USING (`address_id`)
    JOIN `towns` t USING (`town_id`)
    WHERE t.`name` = town_name);
    RETURN result;
END$$
DELIMITER ;

# 2. Employees Promotion
DELIMITER $$
CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(50))
BEGIN
	UPDATE `employees`
	JOIN `departments` USING (`department_id`)
    SET `salary` = `salary` * 1.05
    WHERE `name` = department_name;
END$$
DELIMITER ;

# 3. Employees Promotion By ID
DELIMITER $$
CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN
	UPDATE `employees`
    SET `salary` = `salary` * 1.05
    WHERE `employee_id` = id;
END$$
DELIMITER ;

# 4. Triggered
CREATE TABLE `deleted_employees` (
    `employee_id`  INT PRIMARY KEY AUTO_INCREMENT,
    `first_name`  VARCHAR(50),
    `last_name`    VARCHAR(50),
    `middle_name`  VARCHAR(50),
    `job_title`    VARCHAR(50),
    `department_id` INT,
    `salary`       DECIMAL(19, 4)
);

DELIMITER $$
CREATE TRIGGER `tr_after_delete_employees`
AFTER DELETE
ON `employees`
FOR EACH ROW
BEGIN
    INSERT INTO `deleted_employees` (`first_name`, `last_name`, `middle_name`, `job_title`, `department_id`, `salary`)
    VALUES (OLD.`first_name`,
            OLD.`last_name`,
            OLD.`middle_name`,
            OLD.`job_title`,
            OLD.`department_id`,
            OLD.`salary`);
END$$
DELIMITER ;


