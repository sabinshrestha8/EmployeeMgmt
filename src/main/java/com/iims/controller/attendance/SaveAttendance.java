package com.iims.controller.attendance;

import com.iims.dao.AttendanceDao;
import com.iims.dao.EmployeeDao;
import com.iims.dao.impl.AttendanceDaoImpl;
import com.iims.dao.impl.EmployeeDaoImp;
import com.iims.models.Employee;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

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
        } catch (IOException e) {
            throw e;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw e;
                }
            }
        }

        body = stringBuilder.toString();
        return body;
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
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
