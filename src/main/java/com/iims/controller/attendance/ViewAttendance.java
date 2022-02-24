package com.iims.controller.attendance;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "attendance-view", urlPatterns = "/attendance-view")
public class ViewAttendance extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("user")!=null){
            req.setAttribute("attendances", "Attendance");
            RequestDispatcher requestDispatcher= req.getRequestDispatcher("attendance/attendance-view.jsp");
            requestDispatcher.forward(req, resp);
        }else{
            resp.sendRedirect("admin");
        }
    }

}
