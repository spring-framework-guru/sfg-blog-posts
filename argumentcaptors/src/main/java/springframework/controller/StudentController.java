package springframework.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springframework.domain.Student;
import springframework.service.StudentService;

import java.util.List;


@RestController
//RequestMapping annotation maps HTTP requests to handler methods
@RequestMapping(value = "/api/v1/")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    //save a new student
    @PostMapping("student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    //retrieve all students
    @GetMapping("students")
    public ResponseEntity<List<Student>> getAllStudents() {
        logger.info(".... Fetching all students");
        List<Student> retrievedStudents = studentService.getAllStudents();
        return  new ResponseEntity<List<Student>>((List<Student>) retrievedStudents, HttpStatus.OK);
    }

    //retrieve student by id
    @GetMapping("student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student retrievedstudent =  studentService.getStudentById(id);
        return  new ResponseEntity<>(retrievedstudent, HttpStatus.OK);
    }
    //delete student by id
    @DeleteMapping("student/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id) {
        Student deletedStudent =  studentService.deleteStudentById(id);
        return new ResponseEntity<>(deletedStudent, HttpStatus.OK);
    }

    //update user
    @PutMapping("student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        logger.info(".... Updating Student Content of id: " + student.getId());
        Student updatedStudent = studentService.updateStudent(student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

}