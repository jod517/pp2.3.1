package testgroup.web.service;

import org.springframework.stereotype.Service;
import testgroup.web.dao.UserDAO;
import testgroup.web.dao.UserDAOImpl;
import testgroup.web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();

    @Transactional
    public List<User> allUsers() {
       return userDAO.allUsers();
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public void delete(User user) {
    userDAO.delete(user);
    }

    @Override
    public void edit(User user) {
        userDAO.edit(user);

    }

    @Override
    public User getById(int id) {
      return userDAO.getById(id);
    }
}
