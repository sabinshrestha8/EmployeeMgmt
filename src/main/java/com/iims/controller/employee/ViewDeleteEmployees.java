package com.iims.controller.employee;

import com.iims.dao.AttendanceDao;
import com.iims.dao.EmployeeDao;
import com.iims.dao.impl.AttendanceDaoImpl;
import com.iims.dao.impl.EmployeeDaoImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "employee-view", urlPatterns = "/employee-view")
public class ViewDeleteEmployees extends HttpServlet {
    EmployeeDao employeeDao = new EmployeeDaoImp();
    AttendanceDao attendanceDao = new AttendanceDaoImpl();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        if(session.getAttribute("user")!= null) {
            String id = req.getParameter("id");
            try {
                if (id != null) {
                    int result = employeeDao.remove(Integer.parseInt(id));
                    if (result == 1) {
                        session.setAttribute("employee", employeeDao.findAll());
                        resp.sendRedirect("employee-view");
                    }
                } else {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date();

                    session.setAttribute("employees", employeeDao.findAll());
                    session.setAttribute("attendances", attendanceDao.findAllByDate(dateFormat.format(date)));

                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("employee/employee-view.jsp");
                    requestDispatcher.forward(req, resp);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        } else{
            resp.sendRedirect("admin");
        }
    }

}
