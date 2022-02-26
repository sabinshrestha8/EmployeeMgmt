package com.iims.dao.impl;

import com.iims.connection.ConnectionFactory;
import com.iims.dao.AttendanceDao;
import com.iims.models.Attendance;
import com.iims.models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDaoImpl implements AttendanceDao {
    private static Connection connection;

    private static PreparedStatement preparedStatement;

    private static ResultSet resultSet;

    @Override
    public int savePresent(Employee employee) throws SQLException, ClassNotFoundException {
        final String QUERY = "INSERT INTO attendance (empId, empName) VALUES (?, ?)";

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setInt(1, employee.getId());
        preparedStatement.setString(2, employee.getName());

        return preparedStatement.executeUpdate();
    }

    @Override
    public int saveAbsent(Employee employee) throws SQLException, ClassNotFoundException {
        final String QUERY = "INSERT INTO attendance (empId, empName, isPresent) VALUES (?, ?, ?)";

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setInt(1, employee.getId());
        preparedStatement.setString(2, employee.getName());
        preparedStatement.setBoolean(3, false);

        return preparedStatement.executeUpdate();
    }

    @Override
    public List<Attendance> findAllByDate(String date) throws SQLException, ClassNotFoundException {
        final List<Attendance> attendances = new ArrayList<>();
        final String QUERY = "SELECT * FROM attendance WHERE date LIKE ?";

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setString(1, date + "%");

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Attendance attendance = new Attendance();

            attendance.setEmpId(Integer.parseInt(resultSet.getString("empId")));
            attendance.setEmpName(resultSet.getString("empName"));
            attendance.setDate(resultSet.getString("date").split("\\s")[0]);
            attendance.setIsPresent(resultSet.getBoolean("isPresent"));

            attendances.add(attendance);
        }

        return attendances;
    }

    @Override
    public List<Attendance> findAllByEmpId(int id) throws SQLException, ClassNotFoundException {
        final List<Attendance> attendances = new ArrayList<>();
        final String QUERY = "SELECT * FROM attendance WHERE empId = ?";

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setInt(1, id);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Attendance attendance = new Attendance();

            attendance.setEmpId(Integer.parseInt(resultSet.getString("empId")));
            attendance.setEmpName(resultSet.getString("empName"));
            attendance.setDate(resultSet.getString("date").split("\\s")[0]);
            attendance.setIsPresent(resultSet.getBoolean("isPresent"));

            attendances.add(attendance);
        }

        return attendances;
    }
}
