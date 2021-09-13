package web.dao;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import web.models.User;

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
        return entityManager.find(User.class, id);
    }
    
    @Override
    public User getByName(String name) {
        return entityManager
                .createQuery("SELECT u FROM User u WHERE u.login=:name", User.class)
                .setParameter("name", name)
                .getSingleResult();
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
