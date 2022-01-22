package web.services;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(long id);
    void save(User user);
    void update(User user);
    void deleteById(long id);
}
