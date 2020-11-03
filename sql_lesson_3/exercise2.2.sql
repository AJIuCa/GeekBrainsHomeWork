SELECT 
    MAX(salary) AS 'Максимальная зарплата сотрудника'
FROM
    employees.salaries
WHERE
    emp_no = 10001  -- указываем номер интересующего сотрудника