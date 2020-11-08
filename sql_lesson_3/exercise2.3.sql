DELETE FROM employees.salaries
WHERE
salary = (SELECT * FROM (SELECT MAX(salary) FROM employees.salaries) as slr)