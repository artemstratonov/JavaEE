package db;

import classes.Apartment;
import classes.Realtor;

public class DAOService {

    public static ApartmentDAO apartmentDAO = new ApartmentDAO();
    public static ContractDAO contractDAO = new ContractDAO();
    public static RealtorDAO realtorDAO = new RealtorDAO();
    public static UserDAO userDAO = new UserDAO();

    public static ApartmentDAO getApartmentDAO() {
        return apartmentDAO;
    }

    public static ContractDAO getContractDAO() {
        return contractDAO;
    }

    public static RealtorDAO getRealtorDAO() {
        return realtorDAO;
    }

    public static UserDAO getUserDAO() {
        return userDAO;
    }

    public static void setApartmentDAO(ApartmentDAO apartmentDAO) {
        DAOService.apartmentDAO = apartmentDAO;
    }

    public static void setContractDAO(ContractDAO contractDAO) {
        DAOService.contractDAO = contractDAO;
    }

    public static void setRealtorDAO(RealtorDAO realtorDAO) {
        DAOService.realtorDAO = realtorDAO;
    }

    public static void setUserDAO(UserDAO userDAO) {
        DAOService.userDAO = userDAO;
    }
}
