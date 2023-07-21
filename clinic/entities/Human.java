package clinic.entities;

public abstract class Human {
    private String name;
    private String surname;
    private Integer age;

    public Human(String name, String surname, Integer age) {
        setName(name);
        setSurname(surname);
        setAge(age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public String toString() {
        return "Patient {" +
                ", name = '" + getName() + '\'' +
                ", surname = '" + getSurname() + '\'' +
                ", age = '" + getAge() + '\'' +
                '}';
    }
}
