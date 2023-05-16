package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Employee;
import com.masai.dto.EmployeeImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void addEmployee(Employee emp) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "INSERT INTO employee (empId, ename, address, mobile, deptId) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, emp.getEmpId());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getAddress());
			ps.setString(4, emp.getMobile());
			ps.setString(5, emp.getDeptId());
			ps.executeUpdate();
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to insert the record now, try again later");
		}finally {
			try {
				DBUtils.closeConnection(conn);					
			}catch(SQLException ex) {
				
			}
		}
	}

	@Override
	public List<Employee> searchEmployeeByDepartmentName(String name)
			throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<Employee> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "SELECT empId, ename, address, mobile, deptId FROM employee e INNER JOIN department d ON e.deptId = d.dId WHERE dname = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No mobile found");
			}
			while(rs.next()) {
				list.add(new EmployeeImpl(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to update the record now, try again later");
		}finally {
			try {
				DBUtils.closeConnection(conn);					
			}catch(SQLException ex) {
				
			}
		}
		return list;
	}

}
