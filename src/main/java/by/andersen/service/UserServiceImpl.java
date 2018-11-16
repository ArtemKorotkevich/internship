package by.andersen.service;

import by.andersen.beans.User;
import by.andersen.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public int saveUser(User user) {
        return userDao.saveUser(user);
    }

    public User getUser(int id) {
        return userDao.getUser(id) ;
    }

    public List<User> list() {
        return userDao.list();
    }
    @Transactional
    public void update(int id, User user) {
        userDao.update(id, user);
    }
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }
}
