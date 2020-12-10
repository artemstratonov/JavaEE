package servlets;

import classes.Apartment;
import db.ApartmentDAO;
import db.RealtorDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class SearchApartment extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Apartment a;
        ApartmentDAO dao = new ApartmentDAO();
        a = dao.search(Integer.parseInt(req.getParameter("search")),req.getParameter("id"));
        req.setAttribute("answer", a);
        getServletContext().getRequestDispatcher("/apartmentstable").forward(req, resp);
        //resp.sendRedirect("/Lab1_war/apartmentstable");
    }
}
