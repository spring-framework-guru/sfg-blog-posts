DROP DATABASE IF EXISTS userprofiledb;
DROP USER IF EXISTS `userprofileadmin`@`%`;
DROP USER IF EXISTS `userprofileuser`@`%`;
CREATE DATABASE IF NOT EXISTS userprofiledb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `userprofileadmin`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `userprofiledb`.* TO `userprofileadmin`@`%`;
CREATE USER IF NOT EXISTS `userprofileuser`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON `userprofiledb`.* TO `userprofileuser`@`%`;
FLUSH PRIVILEGES;