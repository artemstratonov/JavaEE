package servlets;

import classes.User;
import db.UserDAO;

import javax.persistence.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO udao = new UserDAO();
        User u = udao.read(req.getParameter("username"));
        if(u.getPassword().equals(req.getParameter("password"))) {
            if (u.getRole() == 1) {
                resp.sendRedirect("/Lab1_war/adaccess");
            } else {
                resp.sendRedirect("/Lab1_war/uaccess");
            }
        }

    }
}
