package com.iims.controller.department;

import com.iims.dao.DepartmentDao;
import com.iims.dao.impl.DepartmentDaoImp;
import com.iims.models.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "department-form", urlPatterns = "/department-form")
public class AddDepartment extends HttpServlet {
    DepartmentDao departmentDao = new DepartmentDaoImp();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("department/department-form.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("login");
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        Department department = new Department(name);
        try {
            int result = departmentDao.save(department);
            if (result > 0) {
                resp.sendRedirect("department-view");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
