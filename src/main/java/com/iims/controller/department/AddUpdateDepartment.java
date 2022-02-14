package com.iims.controller.department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "department-form", urlPatterns = "/department-form")
public class AddUpdateDepartment extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("action", "Save");
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("department/department-form.jsp");
        requestDispatcher.forward(req, resp);
    }

}
