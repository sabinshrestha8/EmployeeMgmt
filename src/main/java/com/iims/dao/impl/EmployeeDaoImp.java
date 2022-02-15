package com.iims.dao.impl;

import com.iims.connection.ConnectionFactory;
import com.iims.dao.EmployeeDao;
import com.iims.models.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDaoImp implements EmployeeDao {
    private static Connection connection;

    private static PreparedStatement preparedStatement;

    private static ResultSet resultSet;

    @Override
    public int save(Employee employee) throws ClassNotFoundException, SQLException {
        final String QUERY = "INSERT INTO employee (name, contact, address, age, departmentId) VALUES (?,?,?,?,?)";

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setString(1, employee.getName().trim());
        preparedStatement.setLong(2, employee.getContact());
        preparedStatement.setString(3, employee.getAddress().trim());
        preparedStatement.setInt(4, employee.getAge());
        preparedStatement.setInt(5, employee.getDepartmentId());

        return preparedStatement.executeUpdate();
    }

    @Override
    public List<Employee> findAll() throws ClassNotFoundException, SQLException {
        final List<Employee> books = new ArrayList<>();
        final String QUERY = "SELECT * FROM employee";

        connection = ConnectionFactory.getConnection();
        resultSet = connection.prepareStatement(QUERY).executeQuery();

        while (resultSet.next()) {
            Employee employee = new Employee();

            employee.setId(resultSet.getInt("id"));
            employee.setName(resultSet.getString("name"));
            employee.setContact(resultSet.getLong("contact"));
            employee.setAddress(resultSet.getString("address"));
            employee.setAge(resultSet.getInt("age"));
            employee.setJoinDate(resultSet.getString("joinDate").split("\\s")[0]);
            employee.setDepartmentId(resultSet.getInt("departmentId"));

            books.add(employee);
        }

        return books;
    }

    @Override
    public Employee findOne(int id) throws ClassNotFoundException, SQLException {
        final String QUERY = "SELECT * FROM employee WHERE id = ?";

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setInt(1, id);

        resultSet = preparedStatement.executeQuery();

        Employee employee = new Employee();

        while (resultSet.next()) {
            employee.setId(resultSet.getInt("id"));
            employee.setName(resultSet.getString("name"));
            employee.setContact(resultSet.getLong("contact"));
            employee.setAddress(resultSet.getString("address"));
            employee.setAge(resultSet.getInt("age"));
            employee.setDepartmentId(resultSet.getInt("departmentId"));
        }

        return employee;
    }

    @Override
    public int update(Employee employee) throws ClassNotFoundException, SQLException {
        final String QUERY = "UPDATE employee SET name = ?, contact = ?, address = ?, age = ?, departmentId = ? WHERE id = ?";

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setString(1, employee.getName().trim());
        preparedStatement.setLong(2, employee.getContact());
        preparedStatement.setString(3, employee.getAddress().trim());
        preparedStatement.setInt(4, employee.getAge());
        preparedStatement.setInt(5, employee.getDepartmentId());
        preparedStatement.setInt(6, employee.getId());

        return preparedStatement.executeUpdate();

    }

    @Override
    public int remove(int id) throws ClassNotFoundException, SQLException {
        final String QUERY = "DELETE FROM employee WHERE id = ?";

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setInt(1, id);

        return preparedStatement.executeUpdate();
    }
}
