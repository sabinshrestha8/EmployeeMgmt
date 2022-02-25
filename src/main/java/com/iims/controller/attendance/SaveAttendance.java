package com.iims.controller.attendance;

import com.iims.dao.AttendanceDao;
import com.iims.dao.EmployeeDao;
import com.iims.dao.impl.AttendanceDaoImpl;
import com.iims.dao.impl.EmployeeDaoImp;
import com.iims.models.Attendance;
import com.iims.models.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "attendance", urlPatterns = "/attendance")
public class SaveAttendance extends HttpServlet {

    public static String getBody(HttpServletRequest request) throws IOException {

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        body = stringBuilder.toString();
        return body;
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String isPresent = req.getParameter("isPresent");
        EmployeeDao employeeDao = new EmployeeDaoImp();
        AttendanceDao attendanceDao = new AttendanceDaoImpl();
        try {
            Employee employee = employeeDao.findOne(Integer.parseInt(id));
            if (isPresent != null) {
                attendanceDao.savePresent(employee);
            } else {
                attendanceDao.saveAbsent(employee);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
