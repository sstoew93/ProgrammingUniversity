package bg.softuni.SpringInit;

import bg.softuni.SpringInit.entities.Account;
import bg.softuni.SpringInit.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Main implements CommandLineRunner {

    private UserService userService;

    public Main(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        Account account = new Account(BigDecimal.valueOf(10000));
        User user = new User("test2", 20, List.of(account));

        userService.register(user);

        User result = userService.get(1);

        userService.addAccountWithBalance(result, 1200);

        User getUser = userService.getByAccount(2);

        System.out.println(getUser);

    }
}
