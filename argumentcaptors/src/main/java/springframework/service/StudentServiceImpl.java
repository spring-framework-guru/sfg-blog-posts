package springframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springframework.domain.Student;
import springframework.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl() {
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public StudentServiceImpl( StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }



}
