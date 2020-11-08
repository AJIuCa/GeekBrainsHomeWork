DROP TRIGGER IF EXISTS `employees`.`employees_AFTER_INSERT`;

DELIMITER $$
USE `employees`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `employees_AFTER_INSERT` AFTER INSERT ON `employees` FOR EACH ROW BEGIN
INSERT INTO salaries (emp_no, salary, from_date, to_date) VALUES
(NEW.emp_no, 50000, NOW(), NOW());
END$$
DELIMITER ;
