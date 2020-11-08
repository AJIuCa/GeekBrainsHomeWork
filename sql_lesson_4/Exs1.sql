CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `employees_view` AS
    SELECT 
        `employees`.`first_name` AS `first_name`,
        `employees`.`last_name` AS `last_name`,
        `departments`.`dept_name` AS `dept_name`
    FROM
        ((`dept_emp`
        JOIN `employees` ON ((`dept_emp`.`emp_no` = `employees`.`emp_no`)))
        JOIN `departments` ON ((`dept_emp`.`dept_no` = `departments`.`dept_no`)))