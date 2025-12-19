import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    private static final String STUDENTS_FILE = "students.txt";
    private static final String INSTRUCTORS_FILE = "instructors.txt";
    private static final String CERTIFICATES_FILE = "certificates.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Student> students = loadStudents();
        List<Instructor> instructors = loadInstructors();
        List<Certificate> certificates = loadCertificates(students, new ArrayList<>());


        List<Category> categories = List.of(
                new Category("Programming"),
                new Category("Design"),
                new Category("Math")
        );

        List<Course> courses = new ArrayList<>();
        for (Category cat : categories) {
            courses.addAll(cat.getCourses());
        }

        List<Submission> submissions = new ArrayList<>();

        boolean running = true;
        while (running) {
            System.out.println("\n========== LEARNING MANAGEMENT SYSTEM ==========");
            System.out.println("                    MAIN MENU                   ");
            System.out.println("================================================");
            System.out.println("1.  Students");
            System.out.println("2.  Instructors");
            System.out.println("3.  Courses");
            System.out.println("4.  Lessons");
            System.out.println("5.  Assignments");
            System.out.println("6.  Certificates");
            System.out.println("0.  Exit");
            System.out.println("================================================");
            System.out.print("Choose option: ");

            int choice = safeIntInput(sc);

            switch (choice) {

                case 1 -> {
                    System.out.println("\n--- STUDENT MENU ---");
                    System.out.println("1. Add student");
                    System.out.println("2. Print all students");
                    System.out.println("0. Back");
                    System.out.print("Choose: ");
                    int ch = safeIntInput(sc);
                    switch (ch) {
                        case 1 -> addStudent(sc, students);
                        case 2 -> printStudents(students);
                    }
                }

                case 2 -> {
                    System.out.println("\n--- INSTRUCTOR MENU ---");
                    System.out.println("1. Add instructor");
                    System.out.println("2. Print all instructors");
                    System.out.println("0. Back");
                    System.out.print("Choose: ");
                    int ch = safeIntInput(sc);
                    switch (ch) {
                        case 1 -> addInstructor(sc, instructors);
                        case 2 -> printInstructors(instructors);
                    }
                }

                case 3 -> {
                    System.out.println("\n--- COURSE MENU ---");
                    System.out.println("1. Add course");
                    System.out.println("2. Print all courses");
                    System.out.println("3. Enroll student to course");
                    System.out.println("0. Back");
                    System.out.print("Choose: ");
                    int ch = safeIntInput(sc);
                    switch (ch) {
                        case 1 -> addCourse(sc, courses, instructors);
                        case 2 -> printCourses(courses);
                        case 3 -> enrollStudent(sc, students, courses);
                    }
                }

                case 4 -> {
                    System.out.println("\n--- LESSON MENU ---");
                    System.out.println("1. Add lesson to course");
                    System.out.println("2. Print lessons");
                    System.out.println("0. Back");
                    System.out.print("Choose: ");
                    int ch = safeIntInput(sc);
                    switch (ch) {
                        case 1 -> addLessonToCourse(sc, courses);
                        case 2 -> printLessons(sc, courses);
                    }
                }

                case 5 -> {
                    System.out.println("\n--- ASSIGNMENT MENU ---");
                    System.out.println("1. Student submits assignment");
                    System.out.println("2. Instructor grades assignment");
                    System.out.println("0. Back");
                    System.out.print("Choose: ");
                    int ch = safeIntInput(sc);
                    switch (ch) {
                        case 1 -> submitAssignment(sc, students, submissions);
                        case 2 -> gradeAssignment(sc, instructors, submissions);
                    }
                }

                case 6 -> {
                    System.out.println("\n--- CERTIFICATE MENU ---");
                    System.out.println("1. Issue certificate");
                    System.out.println("2. Print certificates");
                    System.out.println("0. Back");
                    System.out.print("Choose: ");
                    int ch = safeIntInput(sc);
                    switch (ch) {
                        case 1 -> issueCertificate(sc, students, courses, certificates);
                        case 2 -> printCertificates(certificates);
                    }
                }

                case 0 -> {
                    System.out.println("Saving and exiting...");
                    saveStudents(students);
                    saveInstructors(instructors);
                    saveCertificates(certificates);
                    running = false;
                }

                default -> System.out.println("Invalid choice!");
            }
        }

    
        sc.close();
    }


    private static void addStudent(Scanner sc, List<Student> students) {
        System.out.print("Enter student's name: ");
        String name = sc.nextLine().trim();

        if (findStudentByName(name, students) != null) {
            System.out.println("Student with this name already exists!");
            return;
        }

        System.out.print("Enter email: ");
        String email = sc.nextLine().trim();

        if (!isValidEmail(email)) {
            System.out.println("Invalid email format!");
            return;
        }

        boolean emailExists = students.stream()
                .anyMatch(s -> s.getEmail().equalsIgnoreCase(email));
        if (emailExists) {
            System.out.println("Student with this email already exists!");
            return;
        }


        Student s = new Student(students.size() + 1, name, email, new ArrayList<>(), new HashMap<>());
        students.add(s);
        saveStudents(students);
        System.out.println("Added student: " + name);
    }



    private static void addInstructor(Scanner sc, List<Instructor> instructors) {
        System.out.print("Enter instructor's name: ");
        String name = sc.nextLine().trim();

        if (findInstructorByName(name, instructors) != null) {
            System.out.println("Instructor with this name already exists!");
            return;
        }

        System.out.print("Enter email: ");
        String email = sc.nextLine().trim();


        if (!isValidEmail(email)) {
            System.out.println("Invalid email format!");
            return;
        }

        boolean emailExists = instructors.stream()
                .anyMatch(i -> i.getEmail().equalsIgnoreCase(email));
        if (emailExists) {
            System.out.println("Instructor with this email already exists!");
            return;
        }


        Instructor i = new Instructor(instructors.size() + 1, name, email, new ArrayList<>());
        instructors.add(i);
        saveInstructors(instructors);
        System.out.println("Added instructor: " + name);
    }


    private static void printStudents(List<Student> students) {
        if (students.isEmpty()) System.out.println("No available students.");
        else{
            Collections.sort(students);
            students.forEach(s -> System.out.println(s.getInfo() + "\n"));}
    }

    private static void printInstructors(List<Instructor> instructors) {
        if (instructors.isEmpty()) System.out.println("No available instructors.");
        else instructors.forEach(i -> System.out.println(i.getInfo() + "\n"));
    }

    private static void addCourse(Scanner sc, List<Course> courses, List<Instructor> instructors) {
        System.out.print("Enter course's name: ");
        String cname = sc.nextLine().trim();

        if (findCourseByName(cname, courses) != null) {
            System.out.println("A course with this name already exists!");
            return;
        }

        System.out.print("Enter instructor's name for the course: ");
        String iname = sc.nextLine().trim();
        Instructor instr = findInstructorByName(iname, instructors);

        if (instr == null) {
            System.out.println("Instructor is not found!");
            return;
        }

        System.out.print("Enter level (BEGINNER, INTERMEDIATE, ADVANCED): ");
        Level level = Level.valueOf(sc.nextLine().trim().toUpperCase());

        Course c = new Course(courses.size() + 1, cname, new ArrayList<>(), instr, level);
        courses.add(c);
        instr.getTeachingCourses().add(c);

        System.out.println("Added course: " + cname);
    }


    private static void printCourses(List<Course> courses) {
        if (courses.isEmpty()) System.out.println("No available courses.");
        else{
            courses.sort(Comparator
                    .comparing(Course::getName));

            for (Course c : courses) {
            System.out.println(c.getCourseId() + ". " + c.getName() +
                    " (Instructor: " + (c.getInstructor() != null ? c.getInstructor().getName() : "няма") +
                    ", Level: " + c.getLevel() + ")");
        }
        }
    }

    private static void addLessonToCourse(Scanner sc, List<Course> courses) {
        System.out.print("Enter course's name: ");
        String cname = sc.nextLine();
        Course c = findCourseByName(cname, courses);
        if (c == null) {
            System.out.println("Course is not found.");
            return;
        }
        System.out.print("Lesson's title: ");
        String title = sc.nextLine();
        System.out.print("Content: ");
        String content = sc.nextLine();
        System.out.print("Duration (in minutes): ");
        int minutes = safeIntInput(sc);
        Lesson l = new Lesson(title, content, minutes);
        c.addLesson(l);
        System.out.println("Lesson is added.");
    }

    private static void printLessons(Scanner sc, List<Course> courses) {
        System.out.print("Course's name: ");
        String cname = sc.nextLine();
        Course c = findCourseByName(cname, courses);
        if (c == null) {
            System.out.println("Course is not found.");
            return;
        }
        if (c.getLessons().isEmpty()) System.out.println("No available lessons in the course.");
        else for (Lesson l : c.getLessons()) System.out.println(l.getSummary() + "\n");
    }

    private static void enrollStudent(Scanner sc, List<Student> students, List<Course> courses) {
        System.out.print("Student's name: ");
        String sname = sc.nextLine();
        Student s = findStudentByName(sname, students);

        System.out.print("Course's name: ");
        String cname = sc.nextLine();
        Course c = findCourseByName(cname, courses);

        if (s == null || c == null) {
            System.out.println("Invalid data!");
            return;
        }

        if (s.getCourses().contains(c)) {
            System.out.println("This student is already enrolled in this course!");
            return;
        }

        s.enroll(c);
        System.out.println("Student is enrolled for the course.");
    }

    private static void submitAssignment(Scanner sc, List<Student> students, List<Submission> submissions) {
        System.out.print("Student's name: ");
        String sname = sc.nextLine();
        Student s = findStudentByName(sname, students);

        if (s == null) {
            System.out.println("Student is not found!");
            return;
        }

        System.out.print("Assignment's title: ");
        String title = sc.nextLine();

        boolean alreadySubmitted = submissions.stream()
                .anyMatch(sub -> sub.getStudent().equals(s) &&
                        sub.getAssignment().getTitle().equalsIgnoreCase(title));

        if (alreadySubmitted) {
            System.out.println("This assignment has already been submitted by this student!");
            return;
        }

        System.out.print("Description: ");
        String desc = sc.nextLine();

        System.out.print("Due date (YYYY-MM-DD): ");
        LocalDate due = safeDateInput(sc);

        Assignment a = new Assignment(title, desc, due, 0);
        s.submitAssignment(a);
        submissions.add(new Submission(s, a, LocalDateTime.now()));

        System.out.println("Assignment is submitted.");
    }


    private static void gradeAssignment(Scanner sc, List<Instructor> instructors, List<Submission> submissions) {
        System.out.print("Instructor's name: ");
        String iname = sc.nextLine();
        Instructor instr = findInstructorByName(iname, instructors);
        if (instr == null) {
            System.out.println("Instructor is not found!");
            return;
        }
        System.out.print("Assignment's title: ");
        String atitle = sc.nextLine();
        Submission sub = findSubmissionByAssignment(atitle, submissions);
        if (sub == null) {
            System.out.println("There is no assignment with this title!");
            return;
        }
        System.out.print("Enter grade (2.00 - 6.00): ");
        double grade = safeDoubleInput(sc);
        instr.gradeAssignment(sub.getAssignment(), grade);
    }

    private static void issueCertificate(Scanner sc, List<Student> students, List<Course> courses, List<Certificate> certificates) {
        System.out.print("Student's name: ");
        String sname = sc.nextLine();
        Student s = findStudentByName(sname, students);

        System.out.print("Course's name: ");
        String cname = sc.nextLine();
        Course c = findCourseByName(cname, courses);

        if (s == null || c == null) {
            System.out.println("Invalid data!");
            return;
        }


        boolean exists = certificates.stream()
                .anyMatch(cert -> cert.getStudent().equals(s) && cert.getCourse().equals(c));

        if (exists) {
            System.out.println("Certificate for this student and course already exists!");
            return;
        }


        boolean hasGrade = s.getAssignments().entrySet().stream()
                .filter(e -> e.getKey().equals(c))
                .map(Map.Entry::getValue)
                .anyMatch(a -> a.getGrade() >= 2.00);


        if (!hasGrade) {
            System.out.println("Cannot issue certificate! Student has no graded assignments.");
            return;
        }

        Certificate cert = new Certificate(s, c, LocalDate.now());
        certificates.add(cert);
        cert.generateCertificate();

        System.out.println("Certificate is issued.");
    }


    private static void printCertificates(List<Certificate> certs) {
        if (certs.isEmpty()) System.out.println("No available certificates.");
        else certs.forEach(c -> System.out.println(
                "Certificate: " + c.getStudent().getName() + " - " +
                        c.getCourse().getName() + " (" + c.getDateIssued() + ")"));
    }


    private static Student findStudentByName(String name, List<Student> students) {
        return students.stream().filter(s -> s.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    private static Instructor findInstructorByName(String name, List<Instructor> instructors) {
        return instructors.stream().filter(i -> i.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    private static Course findCourseByName(String name, List<Course> courses) {
        return courses.stream().filter(c -> c.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    private static Submission findSubmissionByAssignment(String title, List<Submission> submissions) {
        return submissions.stream().filter(s -> s.getAssignment().getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }


    private static int safeIntInput(Scanner sc) {
        while (true) {
            try { return Integer.parseInt(sc.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.print("Enter valid number: "); }
        }
    }

    private static double safeDoubleInput(Scanner sc) {
        while (true) {
            try { return Double.parseDouble(sc.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.print("Enter valid number: "); }
        }
    }

    private static LocalDate safeDateInput(Scanner sc) {
        while (true) {
            try { return LocalDate.parse(sc.nextLine().trim()); }
            catch (Exception e) { System.out.print("Format must be YYYY-MM-DD: "); }
        }
    }

    private static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    }


    private static void saveStudents(List<Student> students) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(STUDENTS_FILE))) {
            for (Student s : students)
                pw.println(s.getId() + ";" + s.getName() + ";" + s.getEmail());
        } catch (IOException e) { System.out.println("Student saving error!"); }
    }

    private static List<Student> loadStudents() {
        List<Student> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(STUDENTS_FILE))) {
            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split(";");
                list.add(new Student(Integer.parseInt(p[0]), p[1], p[2], new ArrayList<>(), new HashMap<>()));
            }
        } catch (IOException e) { throw new RuntimeException(e); }
        return list;
    }

    private static void saveInstructors(List<Instructor> instructors) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(INSTRUCTORS_FILE))) {
            for (Instructor i : instructors)
                pw.println(i.getId() + ";" + i.getName() + ";" + i.getEmail());
        } catch (IOException e) { System.out.println("Instructor saving error!"); }
    }

    private static List<Instructor> loadInstructors() {
        List<Instructor> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(INSTRUCTORS_FILE))) {
            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split(";");
                list.add(new Instructor(Integer.parseInt(p[0]), p[1], p[2], new ArrayList<>()));
            }
        } catch (IOException e) { throw new RuntimeException(e); }
        return list;
    }

    private static void saveCertificates(List<Certificate> certs) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(CERTIFICATES_FILE))) {
            for (Certificate c : certs)
                pw.println(c.getStudent().getName() + ";" + c.getCourse().getName() + ";" + c.getDateIssued());
        } catch (IOException e) { System.out.println("Certificate saving error!"); }
    }

    private static List<Certificate> loadCertificates(List<Student> students, List<Course> courses) {
        List<Certificate> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(CERTIFICATES_FILE))) {
            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split(";");
                Student s = findStudentByName(p[0], students);
                Course c = findCourseByName(p[1], courses);
                if (s != null && c != null) list.add(new Certificate(s, c, LocalDate.parse(p[2])));
            }
        } catch (IOException e) { throw new RuntimeException(e); }
        return list;
    }
}
