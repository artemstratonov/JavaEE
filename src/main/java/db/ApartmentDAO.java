package db;

import classes.Apartment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ApartmentDAO implements DAO<Apartment, Integer> {
    public List<Apartment> apartmentList;

    public ApartmentDAO() {
        apartmentList = findAll();
    }

    public List<Apartment> getApartmentList() {
        return apartmentList;
    }

    public void setApartmentList(List<Apartment> apartmentList) {
        this.apartmentList = apartmentList;
    }

    @Override
    public boolean create(Apartment entity) {
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
    public Apartment read(Integer i) {
        Apartment a = new Apartment();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("client-persistence-unit");
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("SELECT a from Apartment a where a.id=:id");
            query.setParameter("id", i);
            a = (Apartment) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public boolean update(Apartment entity) {
        boolean res = false;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("client-persistence-unit");
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("SELECT a from Apartment a where a.id=:id");
            query.setParameter("id", entity.getId());
            Apartment udetached = (Apartment) query.getSingleResult();
            em.getTransaction().begin();
            udetached.setAddress(entity.getAddress());
            udetached.setCountOfRooms(entity.getCountOfRooms());
            udetached.setPrice(entity.getPrice());
            em.merge(udetached);
            em.getTransaction().commit();
            res = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /*@Override
    public boolean delete(Apartment entity) {
        boolean res = false;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("client-persistence-unit");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a from Apartment a where a.id=:id");
            query.setParameter("id", entity.getId());
            Apartment a = (Apartment) query.getSingleResult();
            em.remove(a);
            em.getTransaction().commit();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }*/
    @Override
    public boolean delete(Integer i) {
        boolean res = false;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("client-persistence-unit");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a from Apartment a where a.id=:id");
            query.setParameter("id", i);
            Apartment a = (Apartment) query.getSingleResult();
            em.remove(a);
            em.getTransaction().commit();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Apartment> findAll() {
        List<Apartment> list = new ArrayList<>();
         try {
             EntityManagerFactory emf = Persistence.createEntityManagerFactory("client-persistence-unit");
             EntityManager em = emf.createEntityManager();
              list = em.createQuery("SELECT a from Apartment a").getResultList();
             return list;
          }
          catch (Exception e) {
          e.printStackTrace();
           }
        return list;
    }

    public Apartment search(Integer type, String str) {
        Apartment ans = new Apartment();
        if(type == 1){
            int i = Integer.parseInt(str);
            ans = read(i);
            return ans;
        }
        if(type == 2){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("client-persistence-unit");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a from Apartment a where a.address=:address");
            query.setParameter("address", str);
            ans = (Apartment) query.getSingleResult();
            return ans;
        }
        if(type == 3){
            int i = Integer.parseInt(str);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("client-persistence-unit");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a from Apartment a where a.countOfRooms=:count");
            query.setParameter("count", i);
            ans = (Apartment) query.getSingleResult();
            return ans;
        }
        return ans;
    }

}

