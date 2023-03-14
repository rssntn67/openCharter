package OpenCharterDB.repository;

import OpenCharterDB.model.Nave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NaveRepository extends JpaRepository<Nave,
        Long> {

}
