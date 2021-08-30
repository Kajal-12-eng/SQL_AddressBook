
# UC-1-ability to create address book database.

mysql> SHOW DATABASES;
+---------------------+
| Database            |
+---------------------+
| addressbook_service |
| information_schema  |
| mysql               |
| payroll_service     |
| performance_schema  |
| sakila              |
| sys                 |
| world               |
+---------------------+
8 rows in set (0.00 sec)

mysql> USE addressBook_service;
Database changed
mysql> SELECT DATABASE();
+---------------------+
| DATABASE()          |
+---------------------+
| addressbook_service |
+---------------------+
1 row in set (0.00 sec)

# UC-2-Create table for address book

 CREATE TABLE address_book
    -> (
    -> Id                       INT unsigned NOT NULL AUTO_INCREMENT,
    -> First_Name               VARCHAR(100) NOT NULL,
    -> Last_Name                VARCHAR(100) NOT NULL,
    -> Address                  VARCHAR(250) NOT NULL,
    -> City                     VARCHAR(100) NOT NULL,
    -> States                   VARCHAR(100) NOT NULL,
    -> Zip                      INT(12) NOT NULL,
    -> Phone_Number             INT(15) NOT NULL,
    -> Email                    VARCHAR(150) NOT NULL,
    -> PRIMARY KEY              (Id)
    -> );

mysql> DESCRIBE address_book;
+--------------+--------------+------+-----+---------+----------------+
| Field        | Type         | Null | Key | Default | Extra          |
+--------------+--------------+------+-----+---------+----------------+
| Id           | int unsigned | NO   | PRI | NULL    | auto_increment |
| First_Name   | varchar(100) | NO   |     | NULL    |                |
| Last_Name    | varchar(100) | NO   |     | NULL    |                |
| Address      | varchar(250) | NO   |     | NULL    |                |
| City         | varchar(100) | NO   |     | NULL    |                |
| States       | varchar(100) | NO   |     | NULL    |                |
| Zip          | int          | NO   |     | NULL    |                |
| Phone_Number | int          | NO   |     | NULL    |                |
| Email        | varchar(150) | NO   |     | NULL    |                |
+--------------+--------------+------+-----+---------+----------------+
9 rows in set (0.02 sec)

# UC-3-Insert new contacts in address_book.

INSERT INTO address_book
    -> (First_Name, Last_Name, Address, City, States, Zip, Phone_Number, Email) VALUES
    -> ('Moonlight', 'Sunlight', 'Royal Colony', 'Golden City', 'GreaterState', '001002', '00112345678', 'moonlight@lamp.com');
Query OK, 1 row affected (0.03 sec)

 INSERT INTO address_book
    -> (First_Name, Last_Name, Address, City, States, Zip, Phone_Number, Email) VALUES
    -> ('Priyansh', 'Kumar', 'Malabar', 'Mumbai', 'Maharashtra', '530066','9882763875', 'pl@pl.com'),
    -> ('Rahul', 'Singh', 'Guargon Sec-1', 'Guargon', 'Haryana', '530044','9494691888', 'mln@mln.com');
Query OK, 2 rows affected (0.03 sec)
Records: 2  Duplicates: 0  Warnings: 0

 SELECT * FROM address_book;
+----+------------+-----------+---------------+-------------+--------------+--------+--------------+--------------------+
| Id | First_Name | Last_Name | Address       | City        | States       | Zip    | Phone_Number | Email              |
+----+------------+-----------+---------------+-------------+--------------+--------+--------------+--------------------+
|  1 | Moonlight  | Sunlight  | Royal Colony  | Golden City | GreaterState | 001002 | 00112345678  | moonlight@lamp.com |
|  2 | Priyansh   | Kumar     | Malabar       | Mumbai      | Maharashtra  | 530066 | 9882763875   | pl@pl.com          |
|  3 | Rahul      | Singh     | Guargon Sec-1 | Guargon     | Haryana      | 530044 | 9494691888   | mln@mln.com        |
+----+------------+-----------+---------------+-------------+--------------+--------+--------------+--------------------+
3 rows in set (0.00 sec)

# UC-4-update existing contact by using name.

mysql> UPDATE address_book
    -> SET Phone_Number = '9145489092'
    -> WHERE First_Name = 'Moonlight';
Query OK, 1 row affected (0.02 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> SELECT * FROM address_book;
+----+------------+-----------+---------------+-------------+--------------+--------+--------------+--------------------+
| Id | First_Name | Last_Name | Address       | City        | States       | Zip    | Phone_Number | Email              |
+----+------------+-----------+---------------+-------------+--------------+--------+--------------+--------------------+
|  1 | Moonlight  | Sunlight  | Royal Colony  | Golden City | GreaterState | 001002 | 9145489092   | moonlight@lamp.com |
|  2 | Priyansh   | Kumar     | Malabar       | Mumbai      | Maharashtra  | 530066 | 9882763875   | pl@pl.com          |
|  3 | Rahul      | Singh     | Guargon Sec-1 | Guargon     | Haryana      | 530044 | 9494691888   | mln@mln.com        |
+----+------------+-----------+---------------+-------------+--------------+--------+--------------+--------------------+
3 rows in set (0.01 sec)

#UC-5-delet contact by usging First Name.

 Delete from address_book
    -> where First_Name = 'Rahul';
Query OK, 1 row affected (0.02 sec)

select * from address_book;
+----+------------+-----------+--------------+-------------+--------------+--------+--------------+--------------------+
| Id | First_Name | Last_Name | Address      | City        | States       | Zip    | Phone_Number | Email              |
+----+------------+-----------+--------------+-------------+--------------+--------+--------------+--------------------+
|  1 | Moonlight  | Sunlight  | Royal Colony | Golden City | GreaterState | 001002 | 9145489092   | moonlight@lamp.com |
|  2 | Priyansh   | Kumar     | Malabar      | Mumbai      | Maharashtra  | 530066 | 9882763875   | pl@pl.com          |
+----+------------+-----------+--------------+-------------+--------------+--------+--------------+--------------------+
2 rows in set (0.01 sec)

#UC-6-retrieve the Persons details belonging from states and City.

 SELECT * FROM address_book
    -> WHERE States = 'Maharashtra';
+----+------------+-----------+---------+--------+-------------+--------+--------------+-----------+
| Id | First_Name | Last_Name | Address | City   | States      | Zip    | Phone_Number | Email     |
+----+------------+-----------+---------+--------+-------------+--------+--------------+-----------+
|  2 | Priyansh   | Kumar     | Malabar | Mumbai | Maharashtra | 530066 | 9882763875   | pl@pl.com |
+----+------------+-----------+---------+--------+-------------+--------+--------------+-----------+
1 row in set (0.01 sec)

 SELECT * FROM address_book
    -> WHERE City = 'Golden City';
+----+------------+-----------+--------------+-------------+--------------+--------+--------------+--------------------+
| Id | First_Name | Last_Name | Address      | City        | States       | Zip    | Phone_Number | Email              |
+----+------------+-----------+--------------+-------------+--------------+--------+--------------+--------------------+
|  1 | Moonlight  | Sunlight  | Royal Colony | Golden City | GreaterState | 001002 | 9145489092   | moonlight@lamp.com |
+----+------------+-----------+--------------+-------------+--------------+--------+--------------+--------------------+
1 row in set (0.00 sec)

# UC-7-Ability to understand size of address_book by City or States.

mysql> SELECT COUNT(States) FROM address_book;
+---------------+
| COUNT(States) |
+---------------+
|             3 |
+---------------+
1 row in set (0.02 sec)

mysql> SELECT COUNT(City) FROM address_book;
+-------------+
| COUNT(City) |
+-------------+
|           3 |
+-------------+
1 row in set (0.00 sec)

mysql> SELECT COUNT(City) FROM address_book GROUP BY City;
+-------------+
| COUNT(City) |
+-------------+
|           1 |
|           1 |
|           1 |
+-------------+
3 rows in set (0.00 sec)

mysql> SELECT City, COUNT(City) FROM address_book GROUP BY City;
+-------------+-------------+
| City        | COUNT(City) |
+-------------+-------------+
| Golden City |           1 |
| Mumbai      |           1 |
| Guargon     |           1 |
+-------------+-------------+
3 rows in set (0.00 sec)

mysql> SELECT States, COUNT(States) FROM address_book GROUP BY States;
+--------------+---------------+
| States       | COUNT(States) |
+--------------+---------------+
| GreaterState |             1 |
| Maharashtra  |             1 |
| Haryana      |             1 |
+--------------+---------------+
3 rows in set (0.00 sec)


#UC-8-Ability to retrieve entries sorted alphabetically by Person’s name for a given city.


mysql> INSERT INTO address_book
    -> (First_Name, Last_Name, Address, City, States, Zip, Phone_Number, Email) VALUES
    -> ('Kalyan', 'Kumar', 'Andheri', 'Mumbai', 'Maharashtra', '530066','9882763845', 'pl@p.com'),
    -> ('Atik', 'Singh', 'Dharavi', 'Mumbai', 'Maharashtra', '530044','9494631888', 'mlk@mln.com');
Query OK, 2 rows affected (0.02 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM address_book;
+----+------------+-----------+---------------+-------------+--------------+--------+--------------+--------------------+
| Id | First_Name | Last_Name | Address       | City        | States       | Zip    | Phone_Number | Email              |
+----+------------+-----------+---------------+-------------+--------------+--------+--------------+--------------------+
|  1 | Moonlight  | Sunlight  | Royal Colony  | Golden City | GreaterState | 001002 | 9145489092   | moonlight@lamp.com |
|  2 | Priyansh   | Kumar     | Malabar       | Mumbai      | Maharashtra  | 530066 | 9882763875   | pl@pl.com          |
|  4 | Rahul      | Singh     | Guargon Sec-1 | Guargon     | Haryana      | 530044 | 9494691888   | mln@mln.com        |
|  5 | Kalyan     | Kumar     | Andheri       | Mumbai      | Maharashtra  | 530066 | 9882763845   | pl@p.com           |
|  6 | Atik       | Singh     | Dharavi       | Mumbai      | Maharashtra  | 530044 | 9494631888   | mlk@mln.com        |
+----+------------+-----------+---------------+-------------+--------------+--------+--------------+--------------------+
5 rows in set (0.01 sec)

mysql> SELECT * FROM address_book
    -> WHERE city = 'Mumbai'
    -> ORDER BY first_name ASC;
+----+------------+-----------+---------+--------+-------------+--------+--------------+-------------+
| Id | First_Name | Last_Name | Address | City   | States      | Zip    | Phone_Number | Email       |
+----+------------+-----------+---------+--------+-------------+--------+--------------+-------------+
|  6 | Atik       | Singh     | Dharavi | Mumbai | Maharashtra | 530044 | 9494631888   | mlk@mln.com |
|  5 | Kalyan     | Kumar     | Andheri | Mumbai | Maharashtra | 530066 | 9882763845   | pl@p.com    |
|  2 | Priyansh   | Kumar     | Malabar | Mumbai | Maharashtra | 530066 | 9882763875   | pl@pl.com   |
+----+------------+-----------+---------+--------+-------------+--------+--------------+-------------+
3 rows in set (0.01 sec)

mysql> SELECT * FROM address_book
    -> WHERE States = 'Maharashtra'
    -> ORDER BY first_name ASC;
+----+------------+-----------+---------+--------+-------------+--------+--------------+-------------+
| Id | First_Name | Last_Name | Address | City   | States      | Zip    | Phone_Number | Email       |
+----+------------+-----------+---------+--------+-------------+--------+--------------+-------------+
|  6 | Atik       | Singh     | Dharavi | Mumbai | Maharashtra | 530044 | 9494631888   | mlk@mln.com |
|  5 | Kalyan     | Kumar     | Andheri | Mumbai | Maharashtra | 530066 | 9882763845   | pl@p.com    |
|  2 | Priyansh   | Kumar     | Malabar | Mumbai | Maharashtra | 530066 | 9882763875   | pl@pl.com   |
+----+------------+-----------+---------+--------+-------------+--------+--------------+-------------+
3 rows in set (0.00 sec)


#UC-9-Ability to identify each Address Book with name and Type.


mysql> ALTER TABLE Address_Book ADD name VARCHAR(15);
Query OK, 0 rows affected (0.07 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> ALTER TABLE Address_Book ADD type VARCHAR(15) DEFAULT 'Friend';
Query OK, 0 rows affected (0.07 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> SELECT * FROM address_book;
+----+------------+-----------+---------------+-------------+--------------+--------+--------------+--------------------+------+--------+
| Id | First_Name | Last_Name | Address       | City        | States       | Zip    | Phone_Number | Email              | name | type   |
+----+------------+-----------+---------------+-------------+--------------+------00--+--------------+--------------------+------+--------+
|  1 | Moonlight  | Sunlight  | Royal Colony  | Golden City | GreaterState | 001002 | 9145489092   | moonlight@lamp.com | NULL | Friend |
|  2 | Priyansh   | Kumar     | Malabar       | Mumbai      | Maharashtra  | 530066 | 9882763875   | pl@pl.com          | NULL | Friend |
|  4 | Rahul      | Singh     | Guargon Sec-1 | Guargon     | Haryana      | 530044 | 9494691888   | mln@mln.com        | NULL | Friend |
|  5 | Kalyan     | Kumar     | Andheri       | Mumbai      | Maharashtra  | 530066 | 9882763845   | pl@p.com           | NULL | Friend |
|  6 | Atik       | Singh     | Dharavi       | Mumbai      | Maharashtra  | 530044 | 9494631888   | mlk@mln.com        | NULL | Friend |
+----+------------+-----------+---------------+-------------+--------------+--------+--------------+--------------------+------+--------+
5 rows in set (0.00 sec)

#UC-10-Ability to get number of contact persons i.e. count by type

mysql> SELECT COUNT(type) FROM address_book;
+-------------+
| COUNT(type) |
+-------------+
|           5 |
+-------------+
1 row in set (0.01 sec)

mysql> SELECT COUNT(type) FROM address_book GROUP BY type;
+-------------+
| COUNT(type) |
+-------------+
|           5 |
+-------------+
1 row in set (0.00 sec)

mysql> SELECT type, COUNT(type) FROM address_book GROUP BY type;
+--------+-------------+
| type   | COUNT(type) |
+--------+-------------+
| Friend |           5 |
+--------+-------------+
1 row in set (0.00 sec)
