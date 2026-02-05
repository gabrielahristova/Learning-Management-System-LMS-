import java.time.LocalDate;

public class Certificate {
    private Student student;
    private Course course;
    private LocalDate dateIssued;

    public Certificate(Student student, Course course, LocalDate dateIssued) {
        this.student= student;
        this.course = course;
        this.dateIssued = dateIssued;
    }

    public Student getStudent() {  return student; }

    public void setStudent(Student student) {  this.student = student;  }

    public Course getCourse() {  return course; }

    public void setCourse(Course course) {  this.course = course;   }

    public LocalDate getDateIssued() {  return dateIssued;  }

    public void setDateIssued(LocalDate dateIssued) {   this.dateIssued = dateIssued;   }

    public void generateCertificate() {
        System.out.println("Certificate of Completion! \nStudent: " + student.getName() + " \nCourse: " + course.getName() + "\nDate: " + dateIssued);
    }
}
