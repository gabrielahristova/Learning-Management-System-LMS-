import java.time.LocalDateTime;

public class Submission {
    private Student student;
    private Assignment assignment;
    private LocalDateTime submittedOn;

    public Submission(Student student, Assignment assignment, LocalDateTime submittedOn) {
        this.student = student;
        this.assignment = assignment;
        this.submittedOn = submittedOn;
    }

    public Student getStudent() { return student; }

    public void setStudent(Student student) {  this.student = student; }

    public Assignment getAssignment() {  return assignment; }

    public void setAssignment(Assignment assignment) {  this.assignment = assignment;   }

    public LocalDateTime getSubmittedOn() {  return submittedOn;  }

    public void setSubmittedOn(LocalDateTime submittedOn) {  this.submittedOn = submittedOn;  }

    public String getInfo() {
        return "Student: " + student + " is submitting " + assignment + " on " + submittedOn + ".";
    }
}
