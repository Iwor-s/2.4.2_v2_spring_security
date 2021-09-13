package web.dao;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import web.models.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Role> getAll() {
        return entityManager
                .createQuery("FROM Role", Role.class)
                .getResultList();
    }
    
    @Override
    public Role getById(long id) {
        return entityManager.find(Role.class, id);
    }
    
    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }
}
