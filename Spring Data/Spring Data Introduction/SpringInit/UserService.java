package bg.softuni.SpringInit;

import bg.softuni.SpringInit.entities.User;

public interface UserService {
    void register(User user);

    User get(int id);

    void addAccountWithBalance(User user, int balance);

    public User getByAccount(int accId);
}
