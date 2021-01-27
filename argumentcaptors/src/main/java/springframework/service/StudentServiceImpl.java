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

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get() ;
    }

    @Override
    public Student deleteStudentById(int id) {
        Student student = null;
        Optional optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            student = studentRepository.findById(id).get();
            studentRepository.deleteById(id);
        }
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        Student updatedStudent = null;

        Optional optional = studentRepository.findById(student.getId());
        if (optional.isPresent()) {
            Student getStudent = studentRepository.findById(student.getId()).get();
            getStudent.setName(student.getName());
            getStudent.setId(student.getId());
            updatedStudent = saveStudent(getStudent);
        }
        return updatedStudent;
    }

}
