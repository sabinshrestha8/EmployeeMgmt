package com.iims.dao.impl;

import com.iims.connection.ConnectionFactory;
import com.iims.dao.DepartmentDao;
import com.iims.models.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImp implements DepartmentDao {
    private static Connection connection;

    private static PreparedStatement preparedStatement;

    private static ResultSet resultSet;

    @Override
    public int save(Department department) throws ClassNotFoundException, SQLException {
        final String QUERY = "INSERT INTO department (name) VALUES (?)";

        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);

        preparedStatement.setString(1, department.getName().trim());

        return preparedStatement.executeUpdate();
    }

    @Override
    public List<Department> findAll() throws ClassNotFoundException, SQLException {
        final List<Department> departments = new ArrayList<>();
        final String QUERY = "SELECT * FROM department";

        connection = ConnectionFactory.getConnection();
        resultSet = connection.prepareStatement(QUERY).executeQuery();

        while (resultSet.next()) {
            Department department = new Department();

            department.setId(resultSet.getInt("id"));
            department.setName(resultSet.getString("name"));

            departments.add(department);
        }

        return departments;
    }

}
