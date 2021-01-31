package springframework.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Student {

    @Id
    private int Id;
    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        Id = id;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{ Id = " + Id + ", name = '" + name + '\'' + '}';
    }
}
