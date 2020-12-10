package db;

import classes.Apartment;
import classes.Contract;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ContractDAO implements DAO<Contract, Integer> {
    public List<Contract> contractList = new ArrayList<>();

    public ContractDAO() {
        contractList = findAll();
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    @Override
    public boolean create(Contract entity) {
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
    public Contract read(Integer i) {
        Contract c = new Contract();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("client-persistence-unit");
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("SELECT c from Contract c where c.id=:id");
            query.setParameter("id", i);
            c = (Contract) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public boolean update(Contract entity) {
        boolean res = false;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("client-persistence-unit");
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("SELECT c from Contract c where c.id=:id");
            query.setParameter("id", entity.getId());
            Contract udetached = (Contract) query.getSingleResult();
            em.getTransaction().begin();
            udetached.setApartmentid(entity.getApartmentid());
            udetached.setRealtorid(entity.getRealtorid());
            udetached.setId(entity.getId());
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
            Query query = em.createQuery("SELECT c from Contract c where c.id=:id");
            query.setParameter("id", i);
            Contract c = (Contract) query.getSingleResult();
            em.remove(c);
            em.getTransaction().commit();
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Contract> findAll() {
        List<Contract> list = new ArrayList<>();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("client-persistence-unit");
            EntityManager em = emf.createEntityManager();
            list = em.createQuery("SELECT c from Contract c").getResultList();
            return list;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
