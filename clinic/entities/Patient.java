package clinic.entities;

public class Patient extends Human {
    private Integer id;

    public Patient(String name, String surname, Integer age) {
        super(name, surname, age);
    }
    public Patient(Integer id, String name, String surname, Integer age) {
        this(name, surname, age);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Patient {" +
                "id = " + getId() +
                ", name = '" + getName() + '\'' +
                ", surname = '" + getSurname() + '\'' +
                ", age = '" + getAge() + '\'' +
                '}';
    }

}
