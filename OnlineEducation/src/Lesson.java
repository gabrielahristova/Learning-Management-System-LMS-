public class Lesson {
    private String title;
    private String content;
    private int durationMinutes;

    public Lesson(String title, String content, int durationMinutes) {
        this.title = title;
        this.content = content;
        this.durationMinutes = durationMinutes;
    }

    public String getTitle() {  return title;   }

    public void setTitle(String title) {  this.title = title; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public int getDurationMinutes() {   return durationMinutes;    }

    public void setDurationMinutes(int durationMinutes) {   this.durationMinutes = durationMinutes;  }

    public String getSummary() {
        return "Lesson : " + title + "\nContent: " + content + "\nMinutes: " + durationMinutes;
    }
}