package bg.softuni.SpringInit;

import bg.softuni.SpringInit.entities.Account;
import bg.softuni.SpringInit.entities.User;
import bg.softuni.SpringInit.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(User user) {
        userRepository.save(user);
    }

    @Override
    public User get(int id) {
        Optional<User> byId = userRepository.findById(id);

        return byId.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void addAccountWithBalance(User user, int balance) {

        user.getAccounts().add(new Account(BigDecimal.valueOf(100)));
        userRepository.save(user);
    }

    @Override
    public User getByAccount(int accountId) {
        return userRepository.findByAccountsId(accountId).orElseThrow(EntityNotFoundException::new);
    }
}
