package servlets;

import classes.Apartment;
import db.ApartmentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.Set;

public class AddingApartment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Apartment entity = new Apartment(Integer.parseInt(req.getParameter("id")),req.getParameter("address"),Integer.parseInt(req.getParameter("countOfRooms")),Integer.parseInt(req.getParameter("price")));
        ApartmentDAO dao = new ApartmentDAO();
        Set<ConstraintViolation<Apartment>> violations = validator.validate(entity);
        if(violations.isEmpty()) {
            dao.create(entity);
            dao.apartmentList = dao.findAll();
        }
        resp.sendRedirect("/Lab1_war/apartmentstable");
    }
}
