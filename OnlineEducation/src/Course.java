import java.util.List;

public class Course {
    private int courseId;
    private String name;
    private List<Lesson> lessons;
    private Instructor instructor;
    private Level level;

    public Course(int courseId, String name, List<Lesson> lessons, Instructor instructor, Level level) {
        this.courseId = courseId;
        this.name = name;
        this.lessons = lessons;
        this.instructor = instructor;
        this.level = level;
    }

    public int getCourseId() {  return courseId;  }

    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getName() {   return name;    }

    public void setName(String name) {  this.name = name;   }

    public List<Lesson> getLessons() {  return lessons; }

    public void setLessons(List<Lesson> lessons) {  this.lessons = lessons; }

    public Instructor getInstructor() { return instructor;  }

    public void setInstructor(Instructor instructor) {  this.instructor = instructor;   }

    public Level getLevel() {   return level;   }

    public void setLevel(Level level) { this.level = level; }

    public void addLesson(Lesson l) {
        if(l == null) {
            System.out.println("Invalid lesson!");
            return;
        }
        if (!lessons.contains(l)) {
            lessons.add(l);
            System.out.println("Lesson " + l.getTitle() + " is added to the course " + name + ".");
        }
        else {
            System.out.println("This lesson is already added!");
        }
    }

    public void removeLesson(Lesson l) {
        if(l == null) {
            System.out.println("Invalid lesson!");
            return;
        }

        if(lessons.remove(l)) {
            System.out.println("Lesson " + l.getTitle() + " is successfully removed from course " + name + ".");
        }
        else {
            System.out.println("The lesson was not found in the course!");
        }
    }
}
