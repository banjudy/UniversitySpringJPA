package springboot.UniSpringJPA.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.UniSpringJPA.model.Unit;

public interface UnitRepo extends JpaRepository<Unit, String> {
}
