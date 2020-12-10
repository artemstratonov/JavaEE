package db;


import classes.Realtor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class RealtorDAO implements DAO<Realtor, Integer> {

    public List<Realtor> realtorList = new ArrayList<>();

    public List<Realtor> getRealtorList() {
        return realtorList;
    }

    public void setRealtorList(List<Realtor> realtorList) {
        this.realtorList = realtorList;
    }

    public RealtorDAO() {
        realtorList = findAll();
    }

    @Override
    public boolean create(Realtor entity) {
        boolean res = false;
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("client-persistence-unit");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Realtor read(Integer i) {
        Realtor r = new Realtor();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("client-persistence-unit");
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("SELECT r from Realtor r where r.id=:id");
            query.setParameter("id", i);
            r = (Realtor) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public boolean update(Realtor entity) {
        boolean res = false;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("client-persistence-unit");
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("SELECT r from Realtor r where r.id=:id");
            query.setParameter("id", entity.getId());
            Realtor udetached = (Realtor) query.getSingleResult();
            em.getTransaction().begin();
            udetached.setCommission(entity.getCommission());
            udetached.setId(entity.getId());
            udetached.setName(entity.getName());
            udetached.setPhoneNumber(entity.getPhoneNumber());
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
            Query query = em.createQuery("SELECT r from Realtor r where r.id=:id");
            query.setParameter("id", i);
            Realtor r = (Realtor) query.getSingleResult();
            em.remove(r);
            em.getTransaction().commit();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Realtor> findAll() {
        List<Realtor> list = new ArrayList<>();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("client-persistence-unit");
            EntityManager em = emf.createEntityManager();
            list = em.createQuery("SELECT r from Realtor r").getResultList();
            return list;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
