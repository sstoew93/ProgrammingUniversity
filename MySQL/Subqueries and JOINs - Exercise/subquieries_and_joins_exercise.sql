# 1. Employee Address
SELECT e.`employee_id`, e.`job_title`, e.`address_id`, a.`address_text` FROM `employees` AS e
JOIN `addresses` AS a ON e.`address_id` = a.`address_id`
ORDER BY e.`address_id` ASC
LIMIT 5;

# 2. Addresses with Towns
SELECT e.`first_name`, e.`last_name`, t.`name`, a.`address_text` FROM `employees` AS e
JOIN `addresses` AS a ON e.`address_id` = a.`address_id`
JOIN `towns` AS t ON a.`town_id` = t.`town_id`
ORDER BY e.`first_name` ASC, e.`last_name`
LIMIT 5;

# 03. Sales Employee
SELECT e.`employee_id`, e.`first_name`, e.`last_name`, d.`name` AS 'department_name' FROM `employees` AS e
JOIN `departments` AS d ON e.`department_id` = d.`department_id`
WHERE d.`name` = 'Sales'
ORDER BY e.`employee_id` DESC;

# 04. Employee Departments
SELECT e.`employee_id`, e.`first_name`, e.`salary`, d.`name` AS 'department_name' FROM `employees` AS e
JOIN `departments` AS d ON e.`department_id` = d.`department_id`
WHERE e.`salary` > 15000
ORDER BY d.`department_id` DESC
LIMIT 5;

# 05. Employees Without Project
SELECT e.`employee_id`, e.`first_name` FROM `employees` AS e
LEFT JOIN `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id`
WHERE ep.`project_id` IS NULL
ORDER BY e.`employee_id` DESC
LIMIT 3;

# 06. Employees Hired After
SELECT e.`first_name`, e.`last_name`, e.`hire_date`, d.`name` AS `dept_name` FROM `employees` AS e
JOIN `departments` AS d ON e.`department_id` = d.`department_id`
WHERE e.`hire_date` > '1999/01/01' AND d.`name` IN ('Sales', 'Finance')
ORDER BY e.`hire_date` ASC;

# 07. Employees with Project
SELECT e.`employee_id`, e.`first_name`, p.`name`AS `project_name` FROM `employees` AS e
JOIN `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id`
JOIN `projects` AS p ON ep.`project_id` = p.`project_id`
WHERE DATE(p.`start_date`) > '2002/08/13' AND p.`end_date` IS NULL
ORDER BY e.`first_name` ASC, p.`name` ASC 
LIMIT 5;

# 08. Employee 24
SELECT e.`employee_id`, e.`first_name`, IF (YEAR(p.`start_date`) >= '2005', NULL, p.`name`) AS `project_name` FROM `employees` AS e
JOIN `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id`
JOIN `projects` AS p ON ep.`project_id` = p.`project_id`
WHERE e.`employee_id` = 24
ORDER BY `project_name`;

# 09. Employee Manager
SELECT e.`employee_id`, e.`first_name`, e.`manager_id`, m.`first_name` AS `manager_name` FROM `employees` AS e
JOIN `employees` AS m ON e.`manager_id` = m.`employee_id`
WHERE e.`manager_id` IN (3, 7)
ORDER BY e.`first_name` ASC;

# 10. Employee Summary
SELECT e.`employee_id`, CONCAT(e.`first_name`, ' ', e.`last_name`) AS `employee_name`, CONCAT(m.`first_name`, ' ', m.`last_name`) AS `manager_name`, d.`name` AS `department_name` FROM `employees` AS e
JOIN `employees` AS m ON e.`manager_id` = m.`employee_id`
JOIN `departments` AS d ON e.`department_id` = d.`department_id`
ORDER BY e.`employee_id`
LIMIT 5;

# 11. Min Average Salary
SELECT MIN(`avg_salary`) AS `min_average_salary` 
FROM (
    SELECT `department_id`, AVG(`salary`) AS `avg_salary`
    FROM `employees`
    GROUP BY `department_id`
) AS `avg_salary`;

# 12. Highest Peaks in Bulgaria
SELECT mc.`country_code`, m.`mountain_range`, p.`peak_name`, p.`elevation` FROM `mountains_countries` AS mc
JOIN `mountains` AS m ON m.`id` = mc.`mountain_id`
JOIN `peaks` AS p ON m.`id` = p.`mountain_id`
WHERE p.`elevation` > 2835 AND mc.`country_code` = 'BG'
ORDER BY p.`elevation` DESC;

# 13. Count Mountain Ranges
SELECT mc.`country_code`, COUNT(m.`mountain_range`) AS `mountain_range`
FROM `mountains_countries` AS mc
JOIN `mountains` AS m ON mc.`mountain_id` = m.`id`
WHERE mc.`country_code` IN ('BG', 'RU', 'US')
GROUP BY mc.`country_code`
ORDER BY `mountain_range` DESC;

# 14. Countries with Rivers
SELECT cou.`country_name`, r.`river_name` FROM `continents` AS c
LEFT JOIN `countries` AS cou ON c.`continent_code` = cou.`continent_code`
LEFT JOIN `countries_rivers` AS cr ON cou.`country_code` = cr.`country_code`
LEFT JOIN `rivers` AS r ON cr.`river_id` = r.`id`
WHERE c.`continent_name` = 'Africa'
ORDER BY cou.`country_name`
LIMIT 5;

# 15. *Continents and Currencies
SELECT
    c.`continent_code`,
    c.`currency_code`,
    COUNT(*) AS `currency_usage`
FROM `countries` AS c
GROUP BY c.`continent_code`, c.`currency_code`
HAVING `currency_usage` > 1 AND `currency_usage` = (
        SELECT
        COUNT(*) AS `max_usage`
        FROM `countries`
        WHERE `continent_code` = c.`continent_code`
        GROUP BY `currency_code`
        ORDER BY `max_usage` DESC LIMIT 1
    )
ORDER BY c.`continent_code`, c.`currency_code`;

# 16. Countries without any Mountains
SELECT COUNT(*) AS `country_count` FROM `countries` AS c
LEFT JOIN `mountains_countries` mc on c.`country_code` = mc.`country_code`
WHERE `mountain_id` IS NULL;

# 17. Highest Peak and Longest River by Country
SELECT c.`country_name`, MAX(p.`elevation`) AS `highest_peak_elevation`, MAX(r.`length`) AS `longest_river_length` FROM `countries` AS c
    JOIN `mountains_countries` AS mc ON c.`country_code` = mc.`country_code`
    JOIN `peaks` AS p ON mc.`mountain_id` = p.`mountain_id`
    JOIN `countries_rivers` cr on c.`country_code` = cr.`country_code`
    JOIN `rivers` r on r.id = cr.`river_id`
GROUP BY c.`country_name`
ORDER BY `highest_peak_elevation` DESC, `longest_river_length` DESC
LIMIT 5;