package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Department;
import com.masai.dto.DepartmentImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class DepartmentDAOImpl implements DepartmentDAO{

	@Override
	public void addDepartment(Department dept) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "INSERT INTO department (dId, dname, location) VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, dept.getdId());
			ps.setString(2, dept.getDname());
			ps.setString(3, dept.getLocation());
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
	public void deleteDepartment(String did) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "DELETE FROM department WHERE dId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, did);
			ps.executeUpdate();
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to update the record now, try again later");
		}finally {
			try {
				DBUtils.closeConnection(conn);					
			}catch(SQLException ex) {
				
			}
		}
	}

	@Override
	public List<Department> searchDepartmentDetailByAddress(String address)
			throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<Department> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "SELECT dId, dname, location FROM department d INNER JOIN employee e ON e.deptId = d.dId WHERE address = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, address);
			
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No mobile found");
			}
			while(rs.next()) {
				list.add(new DepartmentImpl(rs.getString(1), rs.getString(2), rs.getString(3)));
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
