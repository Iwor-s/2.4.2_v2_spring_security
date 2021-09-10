package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.annotation.PreDestroy;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;
    
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @PreDestroy
    public void factoryClose() {
        if (!sessionFactory.isClosed()) {
            sessionFactory.getCurrentSession().close();
            sessionFactory.close();
            System.out.println("Factory closed");
        }
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from User")
                .getResultList();
    }
    
    @Override
    public User getById(long id) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("FROM User WHERE id=:id")
                .setParameter("id", id)
                .getSingleResult();
    }
    
    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
    
    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }
    
    @Override
    public void deleteById(long id) {
        sessionFactory.getCurrentSession().delete(getById(id));
    }
}
