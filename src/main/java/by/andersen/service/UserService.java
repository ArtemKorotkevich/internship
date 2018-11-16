package by.andersen.service;

import by.andersen.beans.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public int saveUser(User user);

    public User getUser(int id);

    public List<User> list();

    public void update(int id, User user);

    public void delete(int id);
}
