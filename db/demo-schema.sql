create database demo;
create user 'demo'@'%' identified by 'demo';
grant all on demo.* to 'demo'@'%';
use demo;

DROP TABLE IF EXISTS PHONE_NUMBER_VALIDATION;
  
CREATE TABLE PHONE_NUMBER_VALIDATION (
  ID INT  PRIMARY KEY,
  ORIGINAL_PHONE_NUMBER VARCHAR(50) not NULL,
  VALIDATED_PHONE_NUMBER VARCHAR(50) default NULL,
  STATUS INT DEFAULT NULL,
  NOTE VARCHAR(1000) DEFAULT NULL
);