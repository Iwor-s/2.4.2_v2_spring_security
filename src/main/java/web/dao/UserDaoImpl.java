package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<User> getAll() {
        return entityManager
                .createQuery("FROM User", User.class)
                .getResultList();
    }
    
    @Override
    public User getById(long id) {
        return entityManager
                .find(User.class, id);
    }
    
    @Override
    public User getByName(String name) {
        return entityManager.find(User.class, name);
    }
    
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
    
    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
    
    @Override
    public void deleteById(long id) {
        entityManager.remove(getById(id));
    }
}
