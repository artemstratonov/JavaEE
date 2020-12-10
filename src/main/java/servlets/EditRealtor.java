package servlets;

import classes.Realtor;
import db.RealtorDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditRealtor extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Realtor entity = new Realtor(Integer.parseInt(req.getParameter("id")),req.getParameter("name"),req.getParameter("surname"),Integer.parseInt(req.getParameter("phoneNumber")),Integer.parseInt(req.getParameter("commission")));
        RealtorDAO dao = new RealtorDAO();
        dao.update(entity);
        resp.sendRedirect("/Lab1_war/realtortable");
    }
}
