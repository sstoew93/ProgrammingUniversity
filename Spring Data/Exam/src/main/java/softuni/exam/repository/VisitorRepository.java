package softuni.exam.repository;

import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Visitor;

import java.util.Optional;

@Repository

public interface VisitorRepository extends JpaRepository<Visitor, Long> {

    Optional<Visitor> findByFirstNameAndLastName(@Size(min = 2, max = 20) String firstName, @Size(min = 2, max = 20) String lastName);

    @Query("select v from Visitor v where v.personalData.id = :personalDataId")
    Optional<Visitor> findByPersonalData(Long personalDataId);

}
