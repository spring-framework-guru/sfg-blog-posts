package guru.springframework.domain.data;

import lombok.Builder;
import lombok.Data;


/*
generates getters for all fields, setters for all non-final fields,
and appropriate toString, equals and hashCode implementations that
involve the fields of the class
*/
@Data
public class DataUserDemo {
    private int userId;
    private String userName;
    private int userAge;
}
