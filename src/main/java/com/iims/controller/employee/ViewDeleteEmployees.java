package com.iims.controller.employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "employee-view", urlPatterns = "/employee-view")
public class ViewDeleteEmployees extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("employees", "Employee");
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("employee/employee-view.jsp");
        requestDispatcher.forward(req, resp);
    }

}
