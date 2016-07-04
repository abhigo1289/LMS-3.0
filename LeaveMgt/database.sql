

CREATE DATABASE LEAVEMANAGEMENT;
USE LEAVEMANAGEMENT;

CREATE TABLE EMPLOGIN(
EMPID int(10),
EMPPASSWORD VARCHAR(100) NOT NULL,
enabled TINYINT NOT NULL DEFAULT 1 ,
PRIMARY KEY(EMPID));

CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  EMPID int(10),
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_EMPID_role (role,EMPID),
  KEY fk_username_idx (EMPID),
  CONSTRAINT fk_EMPID FOREIGN KEY (EMPID) REFERENCES EMPLOGIN (EMPID));

 update emplogin set emppassword="$2a$10$SFJc29IWoa6oXBLqmAb8fOXP3H7BDtCegpQ9jvwVYC8vNdD8WgZfm" where empid="1234";  
 update emplogin set emppassword="$2a$10$SFJc29IWoa6oXBLqmAb8fOXP3H7BDtCegpQ9jvwVYC8vNdD8WgZfm" where empid="123";
  


INSERT INTO emplogin(empid,emppassword,enabled)
VALUES (1234,'123456', true);

INSERT INTO emplogin(empid,emppassword,enabled)
VALUES (123,'123456', true);

INSERT INTO user_roles (empid, role)
VALUES (1234, 'ROLE_USER');
INSERT INTO user_roles (empid, role)
VALUES (1234, 'ROLE_ADMIN');
INSERT INTO user_roles (empid, role)
VALUES (123, 'ROLE_USER');


CREATE TABLE EMPDETAILS(
EMPID INT(10),
EMPNAME VARCHAR(50),
DATEOFJOINING DATE,
BLOODGRP VARCHAR(10),
GENDER VARCHAR(6),
PLANEDLEAVES DOUBLE(4,2),
UNPLANEDLEAVES DOUBLE(4,2),
EMPMAIL VARCHAR(30),
PRIMARY KEY(EMPMAIL),
CONSTRAINT FK_DETAILS FOREIGN KEY(EMPID) 
REFERENCES EMPLOGIN (EMPID));

insert into empdetails values (123,'kundan','2016-06-30','A+','Male',4.5,4.0,'kundan@cybage.com');
insert into empdetails values (1234,'abhishek','2016-06-30','A+','Male',4.5,4.0,'abhishekgo@cybage.com');

CREATE TABLE EMPLEAVE(
EMPID BIGINT(10),
TYPEOFLEAVE VARCHAR(20),
STARTDATE DATE,
ENDDATE DATE,
FIRSTHALF INT(4),
SECONDHALF INT(4),
STATUS VARCHAR(20),
REASON VARCHAR(50),
phone varchar(10),
PRIMARY KEY (EMPID,STARTDATE) 
);
insert into empleave values(1234,'Planned Leave','2016-06-22','2016-06-28',6,6,'not approved','party','9953748365');



CREATE TABLE MANAGERLEAVE(
 LEAVENUM INT(4) NOT NULL AUTO_INCREMENT,
 EMPID BIGINT(10),
 STATUS VARCHAR(20),
 PRIMARY KEY (LEAVENUM)
 );
 
insert into managerleave (empid,status) values (1234,"approved");