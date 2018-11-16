package by.andersen.dao;

import by.andersen.beans.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class UserDaoImp implements UserDao {


    private SessionFactory sessionFactory;

    public SessionFactory  getSessionFactory (){
       return  this.sessionFactory = sessionFactory;
    }

    public int saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user.getId();
    }

    public User getUser(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    public List<User> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        Query<User> userQuery = session.createQuery(query);
        return userQuery.getResultList();
    }

    public void update(int id, User user) {
        Session session = sessionFactory.getCurrentSession();
        User user2 = session.byId(User.class).load(id);
        user2.setPass(user.getPass());
        user2.setLogin((user.getLogin()));
        session.flush();
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.byId(User.class).load(id);
        session.delete(user);

    }
}