package servlets;

import db.ApartmentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeletingApartment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApartmentDAO dao = new ApartmentDAO();
        dao.delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("/Lab1_war/apartmentstable");
    }
}
