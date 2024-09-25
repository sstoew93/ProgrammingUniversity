USE `soft_uni`;

# 1. Find Names of All Employees by First Name
SELECT `first_name`, `last_name` FROM `employees`
WHERE `first_name` LIKE 'sa%'
ORDER BY `employee_id`;

# 2.Find Names of All Employees by Last Name
SELECT `first_name`, `last_name` FROM `employees`
WHERE `last_name` LIKE '%ei%'
ORDER BY `employee_id`;

# 3. Find First Names of All Employees
SELECT `first_name` FROM `employees`
WHERE `department_id` IN(3, 10) AND YEAR(hire_date) BETWEEN 1995 AND 2005
ORDER BY `employee_id`;

# 4. Find All Employees Except Engineers
SELECT `first_name`, `last_name` FROM `employees`
WHERE `job_title` NOT LIKE '%engineer%'
ORDER BY `employee_id`;

# 5. Find Towns with Name Length
SELECT `name` FROM `towns`
WHERE CHAR_LENGTH(`name`) IN (5, 6)
ORDER BY `name` ASC;

# 6. Find Towns Starting With
SELECT `town_id`, `name` FROM `towns`
WHERE `name` LIKE 'M%' OR `name` LIKE 'K%' OR `name` LIKE 'B%' OR `name` LIKE 'E%'
ORDER BY `name`;

# 7. Find Towns Not Starting With
SELECT `town_id`, `name` FROM `towns`
WHERE `name` NOT LIKE 'R%' AND `name` NOT LIKE 'B%' AND `name` NOT LIKE 'D%'
ORDER BY `name`;

# 8. Create View Employees Hired After 2000 Year
CREATE VIEW `v_employees_hired_after_2000` AS
SELECT `first_name`, `last_name` FROM `employees`
WHERE YEAR(`hire_date`) > 2000;
SELECT * FROM `v_employees_hired_after_2000`;

# 9. Length of Last Name
SELECT `first_name`, `last_name` FROM `employees`
WHERE CHAR_LENGTH(`last_name`) = 5;

# 10. Countries Holding 'A' 3 or More Times
SELECT `country_name`, `iso_code` FROM `countries`
WHERE `country_name` LIKE '%a%a%a%'
ORDER BY `iso_code`;

# 11.  Mix of Peak and River Names
SELECT `peak_name`, `river_name`, LOWER(CONCAT(`peak_name`, SUBSTRING(`river_name`, 2))) AS `mix` FROM `peaks`, `rivers`
WHERE RIGHT(peak_name, 1) = LEFT(river_name, 1)
ORDER BY `mix`;

# 12. Games from 2011 and 2012 Year
SELECT `name`, date_format(`start`, '%Y-%m-%d') AS `start` FROM `games`
WHERE YEAR(`start`) IN (2011, 2012)
ORDER BY `start`, `name`
LIMIT 50;

# 13.  User Email Providers
SELECT `user_name`, SUBSTRING(`email`, LOCATE('@', `email`) + 1) AS `email provider` FROM `users`
ORDER BY `email provider`, `user_name`;

# 14.  Get Users with IP Address Like Pattern
SELECT `user_name`, `ip_address` FROM `users`
WHERE `ip_address` LIKE "___.1%.%.___"
ORDER BY `user_name` ASC;

# 15.  Show All Games with Duration and Part of the Day
SELECT 
  `name` AS `game`, 
  CASE 
    WHEN HOUR(`start`) >= 0 AND HOUR(`start`) < 12 THEN 'Morning'
    WHEN HOUR(`start`) >= 12 AND HOUR(`start`) < 18 THEN 'Afternoon'
    ELSE 'Evening'
  END AS `Part of the Day`,
  CASE 
    WHEN duration < 4 THEN 'Extra Short'
    WHEN duration < 7 THEN 'Short'
    WHEN duration < 11 THEN 'Long'
    ELSE 'Extra Long'
  END AS `Duration`
FROM `games`;
    
# 16.  Orders Table
SELECT `product_name`, `order_date`, ADDDATE(`order_date`, INTERVAL 3 DAY) AS `pay_due`, ADDDATE(`order_date`, INTERVAL 1 MONTH) AS `deliver_due` FROM `orders`;
