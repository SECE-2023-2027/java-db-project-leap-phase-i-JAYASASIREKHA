create database banking;
use banking;
create table customer(cust_id int primary key,name varchar(50),email varchar(100),password varchar(100),mobile_no varchar(40));
ALTER TABLE customer
MODIFY mobile_no BIGINT;
ALTER TABLE customer
DROP COLUMN email;
drop table customer;
CREATE TABLE customer (
    cust_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(100),
    password VARCHAR(100),
    mobile_no VARCHAR(40)
);
INSERT INTO customer (name, email, password, mobile_no)
VALUES 
('priya', 'priya@gmail.com', 'priya@123', '9789765345'),
('abi', 'abi@gmail.com', 'abi@123', '5464567890'),
('jaya', 'jaya@gmail.com', 'jaya@123', '6789567889'),
('anu', 'anu@gmail.com', 'anu@123', '5667889990'),
('anbu', 'anbu@gmail.com', 'anbu@123', '3569054321'),
('rinitha', 'rinitha@gmail.com', 'rinitha@123', '9123456780'),
('sasi', 'sasi@gmail.com', 'sasi@123', '9234567891'),
('rekha', 'rekha@gmail.com', 'rekha@123', '9345678902'),
('bharathi', 'bharathi@gmail.com', 'bharathi@123', '9456789013'),
('arul', 'arul@gmail.com', 'arul@123', '9567890124');
select * from customer where name= "priya";
UPDATE customer
SET email = 'priya@gmail.com'
WHERE cust_id = 1;
delete  from customer where cust_id=1;
select * from customer;
SELECT * FROM customer
WHERE email IS NOT NULL;
create table student(stud_id  int auto_increment primary key,name varchar(100),address varchar(100),department varchar(100));
INSERT INTO student (name, address, department)
VALUES 
('Aarav', '123 Maple St', 'Computer Science'),
('Anaya', '456 Oak Ave', 'Electrical Engineering'),
('Vihaan', '789 Pine Rd', 'Mechanical Engineering'),
('Diya', '101 Birch Ln', 'Civil Engineering'),
('Riya', '202 Cedar St', 'Mathematics'),
('Ishaan', '303 Elm St', 'Physics'),
('Meera', '404 Walnut Ave', 'Chemistry'),
('Aryan', '505 Willow St', 'Biology'),
('Sara', '606 Redwood Rd', 'Information Technology'),
('Kiran', '707 Spruce Ln', 'Environmental Science');
select * from student where department in('Mathematics','Biology','Chemistry');
SELECT * FROM student
WHERE stud_id BETWEEN 2 AND 6;
SELECT * FROM student
ORDER BY name ASC limit 3;
create table employee(emp_id int auto_increment primary key,emp_name varchar(100),address varchar(100),salary varchar(100));
INSERT INTO employee (emp_name, address, salary)
VALUES 
('Ravi', 'Oak St', '50000'),
('Priya', 'Maple Ave', '55000'),
('Anil', ' Birch Ln', '60000'),
('Sunita', 'Pine Rd', '65000'),
('Vikram', 'Cedar St', '70000'),
('Meera', 'Elm St', '52000'),
('Rajesh', 'Walnut Ave', '58000'),
('Lakshmi', ' Willow St', '62000'),
('Amit', 'Redwood Rd', '56000'),
('Nisha', 'Spruce Ln', '54000');
SELECT AVG(salary) AS average_salary
FROM employee;
select sum(salary) from employee;
CREATE TABLE department (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL,
    stud_id INT,
    FOREIGN KEY (stud_id) REFERENCES student(stud_id)
);
SELECT student.stud_id, student.name, student.address, student.department, department.department_name
FROM student
INNER JOIN department ON student.stud_id = department.stud_id;


show databases;
select * from customer;
SELECT * FROM customer WHERE cust_id = 4;
