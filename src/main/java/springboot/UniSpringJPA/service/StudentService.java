package springboot.UniSpringJPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springboot.UniSpringJPA.Repositories.StudentRepo;
import springboot.UniSpringJPA.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class StudentService implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;

    private StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = em.createQuery(
                "SELECT student FROM Student student WHERE student.email = : email",
                Student.class)
                .setParameter("email", email)
                .getSingleResult();

        // em.find(Student.class, email);
        return student;
    }
}
