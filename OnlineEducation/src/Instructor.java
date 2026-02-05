import java.util.ArrayList;
import java.util.List;
public class Instructor extends User implements Gradable {
    private List<Course> teachingCourses;

    public Instructor(int id, String name, String email, List<Course> teachingCourses) {
        super(id, name ,email);
        this.teachingCourses = teachingCourses;
    }

    public Instructor(String name) {
        super(0, name, "unknown@example.com");
        this.teachingCourses = new ArrayList<>();
    }

    public List<Course> getTeachingCourses() {  return teachingCourses; }

    public void setTeachingCourses(List<Course> teachingCourses) {  this.teachingCourses = teachingCourses; }

    @Override
    String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Instructor: ").append(name).append("\n");
        sb.append("Email: ").append(email).append("\n");

        if(teachingCourses.isEmpty()){
            sb.append("Teaching courses: none.");
        }
        else {
            sb.append("Teaching courses:\n");
            for(Course teachingCourse : teachingCourses) {
                sb.append(" - ").append(teachingCourse.getName()).append(" (ID: ").append(teachingCourse.getCourseId()).append(")\n");
            }
        }
        return sb.toString();
    }

    @Override
    public void gradeAssignment(Assignment a, double grade) {
        if(grade < 2.00 || grade > 6.00) {
            System.out.println("Invalid grade!");
        }
        else {
            System.out.println("Assignment: " + a + " is graded with " + grade);
        }
    }
}
