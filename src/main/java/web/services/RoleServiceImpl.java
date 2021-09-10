package web.services;

import org.springframework.stereotype.Service;
import web.dao.RoleDao;
import web.models.Role;

import javax.transaction.Transactional;
import java.util.List;

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
