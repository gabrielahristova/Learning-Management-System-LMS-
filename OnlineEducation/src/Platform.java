import java.util.List;

public class Platform {
    private String name;
    private List<Course> courses;

    public Platform(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {   return name;    }

    public void setName(String name) {  this.name = name;   }

    public List<Course> getCourses() {  return courses; }

    public void setCourses(List<Course> courses) {  this.courses = courses; }

    public void addCourse(Course c){
        if(c == null) {
            System.out.println("Invalid course!");
            return;
        }
        if(!courses.contains(c)) {
            courses.add(c);
            System.out.println("Course " + c.getName() + " is successfully added to platform " + name + ".");
        }
        else {
            System.out.println("This course is already added!");
        }
    }

    public void removeCourse(Course c) {
        if(c == null) {
            System.out.println("Invalid course!");
            return;
        }
        if(courses.remove(c)) {
            System.out.println("Course " + c.getName() + " is successfully removed from platform " + name + ".");
        }
        else {
            System.out.println("This course was not found in the platform!");
        }
    }
}
