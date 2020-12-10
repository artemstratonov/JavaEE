package servlets;

import classes.Apartment;
import classes.Contract;
import db.ApartmentDAO;
import db.ContractDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditContract extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Contract entity = new Contract(Integer.parseInt(req.getParameter("id")),Integer.parseInt(req.getParameter("apartmentid")),Integer.parseInt(req.getParameter("realtorid")));
        ContractDAO dao = new ContractDAO();
        dao.update(entity);
        resp.sendRedirect("/Lab1_war/contractstable");
    }
}
