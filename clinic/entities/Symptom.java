package clinic.entities;

public class Symptom {

    private String title;

    public Symptom(String title) {
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Symptom {" +
                "title = " + title + '}';
    }
}
