package com.iims.controller.employee;

import com.iims.dao.EmployeeDao;
import com.iims.dao.impl.EmployeeDaoImp;
import com.iims.models.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "employee-form", urlPatterns = "/employee-form")
public class AddUpdateEmployee extends HttpServlet {
    EmployeeDao employeeDao = new EmployeeDaoImp();


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        String id = req.getParameter("id");

        if (id != null) {
            try {
                Employee employee = employeeDao.findOne(Integer.parseInt(id));
                session.setAttribute("employee", employee);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("action", "Update");
        } else {
            session.removeAttribute("employee");
            req.setAttribute("action", "Save");
        }
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("employee/employee-form.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String id = req.getParameter("id");
        int result =0;
        String name = req.getParameter("name");
        long contact = Long.parseLong(req.getParameter("contact"));
        String address = req.getParameter("address");
        int age = Integer.parseInt(req.getParameter("age"));
        int departmentId = Integer.parseInt(req.getParameter("departmentId"));
        Employee employee = new Employee(name, contact, address, age, departmentId);
        try{
            if (id.length() > 0) {
                employee.setId(Integer.parseInt(id));
                result = employeeDao.update(employee);
                session.removeAttribute("employee");
            } else {
                result = employeeDao.save(employee);
            }
            if (result > 0) {
                resp.sendRedirect("employee-view");
            }
        }
         catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
