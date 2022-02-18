package com.iims.controller.department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "department-view", urlPatterns = "/department-view")
public class ViewDeleteDepartment extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            req.setAttribute("departments", "department");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("department/department-view.jsp");
            requestDispatcher.forward(req, resp);
    }
}
