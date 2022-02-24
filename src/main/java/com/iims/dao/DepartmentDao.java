package com.iims.dao;

import com.iims.models.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDao {

    int save(Department department) throws SQLException, ClassNotFoundException;

  //  Department findOne(int id) throws SQLException, ClassNotFoundException;

    List<Department> findAll() throws SQLException, ClassNotFoundException;
}
