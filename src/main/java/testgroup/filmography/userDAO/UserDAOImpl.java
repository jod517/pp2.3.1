package testgroup.filmography.userDAO;


import org.springframework.stereotype.Repository;
import testgroup.filmography.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {


    @PersistenceContext
    private EntityManager entityManager;




    public List<User> allUsers() {
        return entityManager.createQuery("from User").getResultList();
    }


    public void add(User user) {
        entityManager.persist(user);
    }


    public void edit(User user)
    {
        entityManager.merge(user);
    }


    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    public void delete(int id) {
        entityManager.remove(getById(id));
    }
}
