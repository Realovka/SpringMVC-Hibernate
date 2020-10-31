package by.realovka.dao;

import by.realovka.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDao {
    @Autowired
    public SessionFactory sessionFactory;

    public void save(User user){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    public User findByLogin(String login){
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createNativeQuery("select User from User where login =: login", User.class)
                .setParameter("login", login).getSingleResult();
    }
}
