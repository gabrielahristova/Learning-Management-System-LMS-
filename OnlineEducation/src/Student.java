import java.util.*;

public class Student extends User implements Enrollable, Comparable<Student> {
    private List<Course> courses;
    private Map<Course, Assignment> assignments;

    public Student(int id, String name, String email, List<Course> courses, Map<Course, Assignment> assignments) {
        super(id, name, email);
        this.courses = new ArrayList<>();
        this.assignments = new HashMap<>();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Map<Course, Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(Map<Course, Assignment> assignments) {
        this.assignments = assignments;
    }

    @Override
    public void enroll(Course c) {
        if(c == null) {
            System.out.println("Invalid course!");
            return;
        }
        if(!courses.contains(c)) {
            courses.add(c);
            System.out.println("Student: " + name + " is enrolled for a course: " + c.getName());
        }
        else {
            System.out.println("Student is already enrolled for this course!");
        }
    }

    public void submitAssignment(Assignment a) {
        if(a == null) {
            System.out.println("Invalid assignment!");
            return;
        }

        if(courses.isEmpty()) {
            System.out.println("You are not enrolled for any courses!");
        }

        System.out.println("Choose a course to submit a assignment to:");
        for(int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getName());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter course number:");
        int choice = scanner.nextInt();

        if(choice < 1 || choice > courses.size()) {
            System.out.println("Invalid course number!");
        }

        Course selectedCourse = courses.get(choice - 1);
        assignments.put(selectedCourse, a);

        System.out.println("Assignment " + a.getTitle() + " is successfully submitted for course " + selectedCourse + ".");
    }

    @Override
    String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("\nStudent Information:\n");
        info.append("ID: ").append(id).append("\n");
        info.append("Name: ").append(name).append("\n");
        info.append("Email: ").append(email).append("\n");

        if(courses.isEmpty()) {
            info.append("Enrolled courses: none\n");
        }
        else {
            info.append("Enrolled courses:\n");
            for(Course course : courses) {
                info.append(" - ").append(course.getName()).append(" (ID: ").append(course.getCourseId()).append(")\n");
            }
        }

        if(assignments.isEmpty()) {
            info.append("No submitted assignments.");
        }
        else {
            info.append("Submitted assignments:\n");
            for(Map.Entry<Course, Assignment> entry : assignments.entrySet()) {
                Course course = entry.getKey();
                Assignment assignment = entry.getValue();
                info.append(" - ").append(assignment.getTitle()).append(" -> Course: ").append(course.getName()).append("\n");
            }
        }
        return info.toString();
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}