package com.iims.controller.attendance;

import com.iims.dao.AttendanceDao;
import com.iims.dao.impl.AttendanceDaoImpl;
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

@WebServlet(name = "attendance-view", urlPatterns = "/attendance-view")
public class ViewAttendance extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String id = req.getParameter("id");

        try {
            if (session.getAttribute("user") != null && id != null) {
                AttendanceDao attendanceDao = new AttendanceDaoImpl();
                req.setAttribute("attendances", attendanceDao.findAllByEmpId(Integer.parseInt(id)));
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("attendance/attendance-view.jsp");
                requestDispatcher.forward(req, resp);
            } else {
                resp.sendRedirect("login");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
