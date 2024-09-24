package exchageLibrary.service.impl;

import exchageLibrary.model.dao.UserDao;
import exchageLibrary.model.entity.User;
import exchageLibrary.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserImpl implements IUser {

    @Autowired
    private UserDao userDao;

    @Transactional
    public User save(User user) {
        return userDao.save(user);
    }

    @Transactional(readOnly = true)
    public User findById(Integer id) {
        return userDao.findById(id).orElse(null);
    }

    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    @Transactional
    public List<User> findAll() {
        Iterable<User> usersIterable = userDao.findAll();
        List<User> usersList = new ArrayList<>();
        usersIterable.forEach(usersList::add);
        return usersList;
    }
}
