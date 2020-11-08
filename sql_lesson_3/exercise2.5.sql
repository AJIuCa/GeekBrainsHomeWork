SELECT 
    COUNT(dept_emp.emp_no) AS 'Численность отдела', SUM(salary) AS 'Затраты на зарплату сотрудникам в отделе'
FROM
    employees.dept_emp
        JOIN
    employees.salaries ON dept_emp.emp_no = salaries.emp_no
WHERE
    dept_no = 'd001'

    -- dept_no = 'd002'
    -- dept_no = 'd003'
    -- dept_no = 'd004'
    -- dept_no = 'd005'    -- Выбираем нужный отдел
    -- dept_no = 'd006'
    -- dept_no = 'd007'
    -- dept_no = 'd008'
    -- dept_no = 'd009'