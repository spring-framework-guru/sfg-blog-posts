package springframework.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springframework.domain.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
}


