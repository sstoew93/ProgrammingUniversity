package bg.softuni.SpringInit.repositories;

import bg.softuni.SpringInit.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByAccountsId(int accountId);

}
