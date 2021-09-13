package web.services;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

import web.dao.RoleDao;
import web.models.Role;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;
    
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    
    @Override
    public List<Role> getAll() {
        return roleDao.getAll();
    }
    
    @Override
    public Role getById(long id) {
        return roleDao.getById(id);
    }
    
    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
