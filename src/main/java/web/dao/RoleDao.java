package web.dao;

import java.util.List;

import web.models.Role;

public interface RoleDao {
    List<Role> getAll();
    Role getById(long id);
    void save(Role role);
}
