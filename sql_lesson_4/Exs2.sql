CREATE DEFINER=`root`@`localhost` FUNCTION `manager_search`(first_name_const TEXT, last_name_const TEXT) RETURNS text CHARSET utf8mb4
    DETERMINISTIC
BEGIN
declare result TEXT;
SELECT 
    departments.dept_name
INTO result FROM
    ((dept_manager
    JOIN employees ON dept_manager.emp_no = employees.emp_no)
    JOIN departments ON dept_manager.dept_no = departments.dept_no)
WHERE
    employees.first_name LIKE first_name_const
        AND employees.last_name LIKE last_name_const;
RETURN result;
END