package servlets;

import db.ContractDAO;
import db.RealtorDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeletingRealtor extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RealtorDAO dao = new RealtorDAO();
        dao.delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("/Lab1_war/realtortable");
    }
}
