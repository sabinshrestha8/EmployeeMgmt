package com.iims.controller.employee;

import com.iims.dao.EmployeeDao;
import com.iims.dao.impl.EmployeeDaoImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "employee-view", urlPatterns = "/employee-view")
public class ViewDeleteEmployees extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EmployeeDao empDao = new EmployeeDaoImp();

        try {
            req.setAttribute("employees", empDao.findAll());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher requestDispatcher= req.getRequestDispatcher("employee/employee-view.jsp");
        requestDispatcher.forward(req, resp);
    }

}
