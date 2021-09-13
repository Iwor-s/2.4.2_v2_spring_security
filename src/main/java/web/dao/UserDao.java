package web.dao;

import java.util.List;

import web.models.User;

public interface UserDao {
    List<User> getAll();
    User getById(long id);
    User getByName(String name);
    void save(User user);
    void update(User user);
    void deleteById(long id);
}
