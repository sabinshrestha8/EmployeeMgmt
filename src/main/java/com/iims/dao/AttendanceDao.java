package com.iims.dao;

import com.iims.models.Attendance;
import com.iims.models.Employee;

import java.sql.SQLException;
import java.util.List;

public interface AttendanceDao {

    int savePresent(Employee employee) throws SQLException, ClassNotFoundException;

    int saveAbsent(Employee employee) throws SQLException, ClassNotFoundException;

    List<Attendance> findAll() throws SQLException, ClassNotFoundException;

    List<Attendance> findAllByEmpId(int id) throws SQLException, ClassNotFoundException;
}

