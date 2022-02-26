package com.iims.controller.department;

import com.iims.dao.DepartmentDao;
import com.iims.dao.impl.DepartmentDaoImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "department-view", urlPatterns = "/department-view")
public class ViewDepartment extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        DepartmentDao departmentDao = new DepartmentDaoImp();
        if (session.getAttribute("user") != null) {
            try {
                session.setAttribute("departments", departmentDao.findAll());
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("department/department-view.jsp");
                requestDispatcher.forward(req, resp);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            resp.sendRedirect("login");
        }
    }
}
