package com.iims.dao;

import com.iims.models.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    int save(Employee employee) throws SQLException, ClassNotFoundException;

    Employee findOne(int id) throws SQLException, ClassNotFoundException;

    List<Employee> findAll() throws SQLException, ClassNotFoundException;

    int update(Employee employee) throws SQLException, ClassNotFoundException;

    int remove(int id) throws SQLException, ClassNotFoundException;
}
