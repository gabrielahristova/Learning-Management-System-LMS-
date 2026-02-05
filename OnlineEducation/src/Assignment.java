import java.time.LocalDate;

public class Assignment {
    private String title;
    private String description;
    private LocalDate dueDate;
    private double grade;

    public Assignment(String title, String description, LocalDate dueDate, double grade) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.grade = grade;
    }

    public String getTitle() {  return title;   }

    public void setTitle(String title) {  this.title = title; }

    public String getDescription() {  return description;   }

    public void setDescription(String description) {  this.description = description; }

    public LocalDate getDueDate() { return dueDate; }

    public void setDueDate(LocalDate dueDate) {  this.dueDate = dueDate;  }

    public double getGrades() {  return grade;  }

    public void setGrades(double grade) {  this.grade = grade;  }

    public void submit(Student s) {
        if(s == null) {
            System.out.println("Invalid student!");
            return;
        }
        System.out.println("Student " + s.getName() + " has submitted the assignment: " + title);
    }

    public double getGrade() {
        return grade;
    }
}
