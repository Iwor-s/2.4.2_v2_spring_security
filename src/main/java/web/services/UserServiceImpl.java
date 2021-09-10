package web.services;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    
    public List<User> getAllUsers() {
        return userDao.getAll();
    }
    
    public User getUserById(long id) {
        return userDao.getById(id);
    }
    
    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }
    
    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }
    
    @Override
    public void deleteUserById(long id) {
        userDao.deleteById(id);
    }
}
