package web.services;

import java.util.List;

import web.models.User;

public interface UserService {
    List<User> getAll();
    User getById(long id);
    void save(User user);
    void update(User user);
    void deleteById(long id);
}
