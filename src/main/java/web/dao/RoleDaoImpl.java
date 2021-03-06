package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
    public Role getByName(String name) {
        return (Role) entityManager
                .createQuery("SELECT r FROM Role r WHERE r.role=:name")
                .setParameter("name", name)
                .getSingleResult();
    }
    
    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }
}
