package servlets;

import classes.Apartment;
import db.ApartmentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditApartment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Apartment entity = new Apartment(Integer.parseInt(req.getParameter("id")),req.getParameter("address"),Integer.parseInt(req.getParameter("countOfRooms")),Integer.parseInt(req.getParameter("price")));
        ApartmentDAO dao = new ApartmentDAO();
        dao.update(entity);
        resp.sendRedirect("/Lab1_war/apartmentstable");
    }

}
