package springframework.service;

import springframework.domain.Student;

import java.util.List;

public interface StudentService {

     Student saveStudent(Student student);

     List<Student> getAllStudents();

     Student getStudentById(int id);

    Student deleteStudentById(int id);

    Student updateStudent(Student student);
}
