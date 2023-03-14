package OpenCharterDB.repository;

import OpenCharterDB.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<Info,
        Long> {
}