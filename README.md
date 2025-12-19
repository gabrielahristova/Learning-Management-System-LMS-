# Learning-Management-System-LMS-
📌 Overview

This project is a console-based Learning Management System (LMS) developed in Java.
It provides functionality for managing students, instructors, courses, lessons, assignments, and certificates.

The application is designed for educational purposes and demonstrates:

Object-Oriented Programming (OOP)

Collections and Streams

File I/O

Input validation and error handling

Console-based user interaction

⚙️ Features
👨‍🎓 Students

Add new students

View all students

Enroll students in courses

Submit assignments

👨‍🏫 Instructors

Add instructors

View all instructors

Grade student assignments

📘 Courses

Create courses

Assign instructors to courses

Course levels: BEGINNER, INTERMEDIATE, ADVANCED

View all courses

📖 Lessons

Add lessons to courses

View lessons for a specific course

📝 Assignments

Students can submit assignments

Instructors can grade assignments

Protection against duplicate submissions

🎓 Certificates

Issue certificates to students

Validation rules:

The student must be enrolled in the course

The student must have at least one graded assignment

A certificate cannot be issued twice for the same student and course

View all issued certificates

🔐 Validations & Safety

The system includes multiple validations to ensure data integrity:

❌ Prevent duplicate students, instructors, and courses

❌ Prevent enrolling a student in the same course more than once

❌ Prevent issuing certificates without graded assignments

❌ Safe handling of invalid input

✔ Robust checks for null values

💾 Data Persistence

Data is stored using plain text files:

students.txt

instructors.txt

certificates.txt

Data is:

Loaded automatically on application startup

Saved when the application exits

File format example:

id;name;email

🧩 Technologies Used

Java SE

Java Collections Framework

Java Streams & Lambdas

Java File I/O

Java Time API

▶️ How to Run

Clone the repository:

git clone https://github.com/gabrielahristova/Learning-Management-System-LMS-.git


Open the project in your IDE (IntelliJ IDEA, Eclipse, etc.)

Run the application:

Main.java

🖥️ Sample Console Menu
══════════════════════════════════════
 LEARNING MANAGEMENT SYSTEM
══════════════════════════════════════
1. Students
2. Instructors
3. Courses
4. Lessons
5. Assignments
6. Certificates
0. Exit

📂 Project Structure
src/
 ├── Main.java
 ├── Student.java
 ├── Instructor.java
 ├── Course.java
 ├── Lesson.java
 ├── Assignment.java
 ├── Submission.java
 ├── Certificate.java
 ├── Category.java
 └── enums/
     └── Level.java

🎯 Project Purpose

This project was created for educational use and demonstrates:

Clean code structure

Object-Oriented design principles

Practical Java application development

Real-world system modeling (LMS)

📜 License

This project is intended for educational purposes and can be freely used and modified.

✨ Author

Gabriela Hristova
Java Developer – Student Project
