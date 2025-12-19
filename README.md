# 📚 Learning Management System (LMS)

> Java console-based Learning Management System  
> Developed as an educational project using Object-Oriented Programming principles.

---

## 📌 Overview
This project is a **console-based Learning Management System (LMS)** developed in **Java**.  
It allows management of **students, instructors, courses, lessons, assignments, and certificates** through an interactive console menu.

The application demonstrates practical usage of Java OOP concepts, collections, file handling, and validations.

---

## 🚀 Features

### 👨‍🎓 Student Management
- Add new students
- View all students
- Enroll students in courses
- Submit assignments

### 👨‍🏫 Instructor Management
- Add instructors
- View all instructors
- Grade student assignments

### 📘 Course & Lesson Management
- Create courses with difficulty levels
- Assign instructors to courses
- Add lessons to courses
- View course lessons

### 📝 Assignments
- Assignment submission by students
- Assignment grading by instructors
- Protection against duplicate submissions

### 🎓 Certificates
- Issue certificates to students
- Validation rules:
  - Student must be enrolled in the course
  - Student must have at least one graded assignment
  - Certificate cannot be issued more than once
- View all issued certificates

---

## 🔐 Validations & Safety
The system includes multiple validations to ensure data consistency:
- Prevent duplicate students, instructors, and courses
- Prevent enrolling a student in the same course more than once
- Prevent issuing certificates without graded assignments
- Safe input handling for numbers and dates
- Protection against `null` values and invalid data

---

## 💾 Data Persistence
Application data is stored using text files:
- `students.txt`
- `instructors.txt`
- `courses.txt`
- `certificates.txt`

Data is automatically:
- Loaded on application startup
- Saved when the application exits

**File format example:**
id;name;email


---

## 🖥️ Console Menu 

```
══════════════════════════════════════
LEARNING MANAGEMENT SYSTEM
══════════════════════════════════════
Students
Instructors
Courses
Lessons
Assignments
Certificates
Exit

```

---

## 🛠️ Technologies Used
- Java SE
- Object-Oriented Programming (OOP)
- Java Collections Framework
- Java Streams & Lambda Expressions
- Java File I/O
- Java Time API

---

## ▶️ How to Run

1. Clone the repository:
git clone https://github.com/gabrielahristova/Learning-Management-System-LMS-.git
Open the project in an IDE (IntelliJ IDEA / Eclipse)

Run:
Main.java

---

## 📁 Project Structure

```
OnlineEducation/
└── src/
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
```

---
         
## 🎯 Project Purpose
This project was developed for educational purposes and demonstrates:

- Clean code structure
- Practical OOP design
- Real-world application modeling
- Console-based user interaction

---

## 📜 License
This project is intended for educational use only and may be freely modified.

---

## 👤 Author
Gabriela Hristova
Java Developer – Student Project
