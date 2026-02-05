import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {   return name;    }

    public void setName(String name) {  this.name = name;   }

    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("courses.txt"))) {
            String line;

            while((line = br.readLine()) != null) {
                if(line.trim().isEmpty()) continue;

                String[] parts = line.split(";");

                if(parts.length == 5) {
                    String categoryName = parts[0].trim();
                    int courseId = Integer.parseInt(parts[1].trim());
                    String courseName = parts[2].trim();
                    String instructorName = parts[3].trim();
                    Level level = Level.valueOf(parts[4].trim().toUpperCase());

                    if(categoryName.equalsIgnoreCase(name)) {
                        courses.add(new Course(courseId, courseName, new ArrayList<>(), new Instructor(instructorName), level));
                    }
                }
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }
}
