DROP DATABASE IF EXISTS bankService;

DROP USER IF EXISTS `bankService`@`%`;

CREATE DATABASE IF NOT EXISTS bankService CHARACTER SET utfemb4 COLLATE utf8mb4_unicode_ci;

CREATE USER IF NOT EXISTS `beer_service`@`%` IDENTIFIED WITH mysql_native_password BY 'password';

GRANT SELECT, INSERT, UPDATE, DELETE, CREATE , DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,

CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `bankService`.* TO `bankService`@`%`;

FLUSH PRIVILEGES;