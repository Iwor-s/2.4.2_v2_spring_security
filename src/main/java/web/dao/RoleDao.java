package web.dao;

import web.models.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAll();
    Role getById(long id);
    void save(Role role);
}
