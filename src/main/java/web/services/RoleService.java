package web.services;

import java.util.List;

import web.models.Role;

public interface RoleService {
    List<Role> getAll();
    Role getById(long id);
    void save(Role role);
}
