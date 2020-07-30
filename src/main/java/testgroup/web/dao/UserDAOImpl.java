package testgroup.web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testgroup.web.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserDAOImpl implements UserDAO {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, User> users = new HashMap<>();

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<User> allUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }


    @Override
    public void add(User user) {
        user.setId( AUTO_ID.getAndIncrement());
        users.put(user.getId(), user);
    }
    @Override
    public void delete(User user) {
        users.remove(user.getId());
    }
    @Override
    public void edit(User user) {
        users.put(user.getId(), user);
    }
    @Override
    public User getById(int id) {
        return users.get(id);
    }
}
