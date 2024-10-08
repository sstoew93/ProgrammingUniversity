# 1. Managers
SELECT
    e.`employee_id`,
    CONCAT_WS(' ', e.first_name, e.last_name) AS `full_name`,
    d.`department_id`,
    d.`name` AS `department_name`
FROM `departments` AS d
JOIN `employees` AS e ON d.`manager_id` = e.`employee_id`
ORDER BY e.`employee_id` 
LIMIT 5;

# 2. Towns and Addresses
SELECT a.`town_id`, t.`name` AS 'town_name', a.`address_text` FROM `addresses` AS a
JOIN `towns` AS t ON a.`town_id` = t.`town_id`
WHERE t.`name` IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY a.`town_id`, a.`address_id`;

# 3. Employees Without Managers
SELECT `employee_id`, `first_name`, `last_name`, `department_id`, `salary` FROM `employees`
WHERE `manager_id` IS NULL;

# 4. Higher Salary
SELECT COUNT(*) FROM `employees`
WHERE (SELECT AVG(`salary`) FROM `employees`) < `salary`;