package com.iims.controller.attendance;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "attendance-view", urlPatterns = "/attendance-view")
public class ViewAttendance extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("attendances", "Attendance");

        RequestDispatcher requestDispatcher= req.getRequestDispatcher("attendance/attendance-view.jsp");
        requestDispatcher.forward(req, resp);
    }

}
