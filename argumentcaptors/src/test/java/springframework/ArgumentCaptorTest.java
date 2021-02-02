package springframework;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import springframework.domain.Student;
import springframework.repository.StudentRepository;
import springframework.service.StudentServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ArgumentCaptorTest {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    @Captor
    private ArgumentCaptor<Student> captor;

    @Test
    public void shouldCapture() {

        Student  student1 = new Student(1, "Harry");
        studentService.saveStudent(student1);

        //verify(mock).doSomething(argument.capture());
        Mockito.verify(studentRepository).save(captor.capture());

        assertEquals("Harry", captor.getValue().getName());
        assertEquals(1,captor.getValue().getId());

    }

    @Test
    public void shouldCaptureMultipleTimes() {

        Student student1 = new Student(1, "Harry");
        Student student2 = new Student(2, "Tae");
        Student student3 = new Student(3, "Louis");

        studentService.saveStudent(student1);
        studentService.saveStudent(student2);
        studentService.saveStudent(student3);

        Mockito.verify(studentRepository,Mockito.times(3)).save(captor.capture());

        List<Student> studentList = captor.getAllValues();

        assertEquals("Harry", studentList.get(0).getName());
        assertEquals("Tae", studentList.get(1).getName());
        assertEquals("Louis", studentList.get(2).getName());
    }

    @Test
    public void shouldCaptureManually() {
        ArgumentCaptor<Student> argumentCaptor = ArgumentCaptor.forClass(Student.class);

        Student student1 = new Student(1, "Harry");
        studentService.saveStudent(student1);

        Mockito.verify(studentRepository).save(argumentCaptor.capture());
        Student captured = argumentCaptor.getValue();

        assertEquals("Harry", captured.getName());

    }
}
