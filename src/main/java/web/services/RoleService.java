package web.services;

import java.util.List;

import web.models.Role;

public interface RoleService {
    List<Role> getAll();
    Role getById(long id);
    Role getByName(String name);
    void save(Role role);
}
