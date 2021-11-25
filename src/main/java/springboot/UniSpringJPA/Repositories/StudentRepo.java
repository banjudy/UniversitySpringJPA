package springboot.UniSpringJPA.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.UniSpringJPA.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
    //Student findAllBy(String email);

}
