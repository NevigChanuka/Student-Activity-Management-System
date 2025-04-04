# Student Activity Management System


[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)  
[![Java](https://img.shields.io/badge/Java-23-%23ED8B00?logo=openjdk&logoColor=white)](https://openjdk.org/projects/jdk/23/)
[![GitHub Stars](https://img.shields.io/github/stars/NevigChanuka/Student-Activity-Management-System?style=social)](https://github.com/NevigChanuka/Student-Activity-Management-System) 


## Overview

This Java application is a Student Management System that allows users to manage student records, module marks, and generate reports. The system provides functionality for registering students, tracking module performance, and generating both summary and detailed reports

## Prerequisites

- Java 23 or later version installed


### Installing Java

1. Download java from **[Java.com](https://www.java.com/)**.

## How to Run

1. Download the project files.
2. Compile all Java files:
```cmd
javac Main.java Student.java Module.java
```
3. Run the application:
```cmd
java Main
```


## Features

### Main Menu Options

1. __Check Available Seats__: Displays the number of available seats for new student registrations.
2. __Register Student__: Allows registration of new students by entering their name and ID.
3. __Delete Student__: Removes a student's record from the system using their ID.
4. __Find Student__: Searches for a student by ID and displays their registration status.
5. __Store Student Details__: Saves all student details to a text file (`StudentDetails.txt`).
6. __Load Student Details__: Loads student details from the text file into the system.
7. __View List of Students__: Displays a sorted list of all registered students by name.
8. __Additional Options__: Provides access to advanced features.
9. __Exit__: Terminates the program.

### Additional Options

1. __Add Student and Module Marks__: Allows entering student details along with their module marks (3 modules).
2. __Create Summary Report__: Generates a summary report showing:
   - Total number of student registrations
   - Number of students who passed each module
3. __Create Complete Report__: Generates a detailed report showing:
   - Student ID and name
   - Marks for all three modules
   - Total marks
   - Average mark
   - Final grade (Distinction, Merit, Pass, or Fail)
4. __Exit to Main Menu__: Returns to the main menu.


## Technical Details

### Classes
1. __Main__: Contains the main menu and core functionality.
2. __Student__: Handles student details (name and ID).
3. __Module__: Manages module marks, calculations, and report generation.

### Data Storage
1. Student details are stored in a 2D array (stuDetialsArray).
2. Student objects are stored in an array (studentsObjectArray).
3. Module objects (containing marks) are stored in an array (moduleObjectArray).
4. Data can be persisted to and loaded from "StudentDetails.txt".

### Validation
1. Module marks are validated to be between 0 and 100.
2. Student IDs are checked for duplicates during registration.

## Notes

 - The system supports up to 100 students (configurable via maxStudent).
 - Module passing mark is set at 40.
 - Grades are calculated based on average marks:
   - 80+ : Distinction
   - 70-79 : Merit
   - 40-69 : Pass
   - Below 40 : Fail

## License
MIT © Nevig Chanuka
