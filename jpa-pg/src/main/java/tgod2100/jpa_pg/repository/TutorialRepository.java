package tgod2100.jpa_pg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tgod2100.jpa_pg.model.Tutorial;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContainingIgnoreCase(String title);
}
