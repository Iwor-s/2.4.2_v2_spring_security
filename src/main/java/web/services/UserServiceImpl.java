package web.services;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

import web.dao.UserDao;
import web.models.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    
    public List<User> getAll() {
        return userDao.getAll();
    }
    
    public User getById(long id) {
        return userDao.getById(id);
    }
    
    @Override
    public void save(User user) {
        userDao.save(user);
    }
    
    @Override
    public void update(User user) {
        userDao.update(user);
    }
    
    @Override
    public void deleteById(long id) {
        userDao.deleteById(id);
    }
}
