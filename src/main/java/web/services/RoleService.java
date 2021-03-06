package web.services;

import web.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    Role getById(long id);
    Role getByName(String name);
    void save(Role role);
}
