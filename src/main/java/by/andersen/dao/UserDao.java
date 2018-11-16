package by.andersen.dao;

import by.andersen.beans.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
    public int saveUser(User user);

    public User getUser(int id);

    public List<User> list();

    public void update(int id, User user);

    public void delete(int id);
}
