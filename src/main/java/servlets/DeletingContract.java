package servlets;

import db.ApartmentDAO;
import db.ContractDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeletingContract extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContractDAO dao = new ContractDAO();
        dao.delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("/Lab1_war/contractstable");
    }
}
