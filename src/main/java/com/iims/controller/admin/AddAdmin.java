package com.iims.controller.admin;

import com.iims.dao.AdminDao;
import com.iims.dao.impl.AdminDaoImpl;
import com.iims.models.Admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "admin", urlPatterns = "/admin")

public class AddAdmin extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("user") == null) {
            req.setAttribute("action", "Save");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("admin/admin-login.jsp");
            requestDispatcher.forward(req, resp);
        }else{
            resp.sendRedirect("./");
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        String password= req.getParameter("password");

        if(email.length()>0 && password.length()>0){
            AdminDao adminDao = new AdminDaoImpl();
            try {
                Admin admin = adminDao.findOne(email, password);
                if(admin !=null){
                    System.out.println("found");
                    session.setAttribute("user", admin);
                    resp.sendRedirect("./");
                }
                else {
                    resp.sendRedirect("admin");
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
