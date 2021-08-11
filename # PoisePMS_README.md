# PoisePMS

PoisePMS is a Java project management system dealing with databases (MySQL). allows user
to manipulate project and personal information. 

## Installation

Download MySQL installer from (https://dev.mysql.com/downloads/mysql/) and (https://www.youtube.com/watch?v=gFVZ2h1Usks)

Use Eclipse/Intellij (eclipse.org/downloads/) or (https://intellij-idea.en.softonic.com/download)

How to connect SQL database to Eclipse (https://www.youtube.com/watch?v=t6NQtfokZr8)

## Usage

```MySQL
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

# Create database
CREATE DATABASE poisepms;

# Create a table
CREATE TABLE Projects(
	PROJ_NUM INT(3) PRIMARY KEY,
    PROJ_NAME VARCHAR(20),
    BUILDING_TYPE VARCHAR(20),
    PHYS_ADDRESS VARCHAR(50),
    ERF_NUM VARCHAR(10),
	TOTAL_FEE DOUBLE,
    AMOUNT_PAID DOUBLE,
	DEADLINE DATE,
	COMPLETION VARCHAR(20),
	STATUS VARCHAR(20)
);


# stores project
// Connect to the library_db database, via the jdbc:mysql: channel on localhost (this PC)
				        // Use username "root", password "password".
				        Connection connection = DriverManager.getConnection(
				                "jdbc:mysql://localhost:3306/poisepms",
				                "username",
				                "password"
				                );


Select from below and follow the steps, start with creating a project(option 1):
1 - To create a new project
2 - To amend project due date
3 - To amend the amount paid
4 - To see over due projects
5 - To Finalise a project
6 - To find a project
7 - To view existing projects
8 - Add Architect information
0 - To Exit
:

