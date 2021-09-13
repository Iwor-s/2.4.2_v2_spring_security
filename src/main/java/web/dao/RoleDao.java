package web.dao;

import java.util.List;

import web.models.Role;

public interface RoleDao {
    List<Role> getAll();
    Role getById(long id);
    Role getByName(String name);
    void save(Role role);
}
