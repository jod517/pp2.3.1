package testgroup.filmography.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testgroup.filmography.userDAO.UserDAO;
import testgroup.filmography.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Transactional
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Transactional
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Transactional
    public User getById(int id) {
        return userDAO.getById(id);
    }
}
