package db;

import classes.Realtor;
import classes.User;
import com.sun.istack.NotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO<User, String> {
    public List<User> userList = new ArrayList<>();

    public UserDAO() {
        userList = findAll();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public boolean create(@NotNull final User entity) {
        boolean res = false;
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("client-persistence-unit");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            entity.setRole(2);
            em.persist(entity);
            em.getTransaction().commit();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public User read(String s) {
        User u = new User();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("client-persistence-unit");
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("SELECT u from User u where u.username=:username");
            query.setParameter("username", s);
            u = (User) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public boolean update(User entity) {
        boolean res = false;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("client-persistence-unit");
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("SELECT u from User u where u.username=:username");
            query.setParameter("username", entity.getUsername());
            User udetached = (User) query.getSingleResult();
            em.getTransaction().begin();
            udetached.setUsername(entity.getUsername());
            udetached.setPassword(entity.getPassword());
            em.merge(udetached);
            em.getTransaction().commit();
            res = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean delete(Integer i) {
        boolean res = false;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("client-persistence-unit");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT u from User u where u.username=:username");
            query.setParameter("username", i);
            User u = (User) query.getSingleResult();
            em.remove(u);
            em.getTransaction().commit();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("client-persistence-unit");
            EntityManager em = emf.createEntityManager();
            list = em.createQuery("SELECT u from User u").getResultList();
            return list;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
