package app.story.repository;

import app.story.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StoryRepository extends JpaRepository<Story, UUID> {

    @Query("SELECT s FROM Story s WHERE s.isVisible = true")
    List<Story> findAllByVisibleTrue();
}
