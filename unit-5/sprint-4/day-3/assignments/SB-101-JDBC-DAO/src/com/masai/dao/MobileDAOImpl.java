package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Mobile;
import com.masai.dto.MobileImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class MobileDAOImpl implements MobileDAO{
	

	public void addMobile(Mobile mob) throws SomethingWentWrongException {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "INSERT INTO mobile (model_no, company, price, MFGdate) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, mob.getModel());
			ps.setString(2, mob.getCompany());
			ps.setInt(3, mob.getPrice());
			ps.setDate(4, Date.valueOf(mob.getMfg()));
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
	

	public void updateMobile(Mobile mob) throws SomethingWentWrongException {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "UPDATE mobile SET company = ?, price = ?, MFGdate = ? WHERE model_no = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, mob.getCompany());
			ps.setInt(2, mob.getPrice());
			ps.setDate(3, Date.valueOf(mob.getMfg()));
			ps.setString(4, mob.getModel());
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
	

	public void deleteMobile(String model) throws SomethingWentWrongException {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "DELETE FROM mobile WHERE model_no = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, model);
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
	

	public List<Mobile> getMobileList() throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn = null;
		List<Mobile> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "SELECT model_no, company, price, MFGdate FROM mobile";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No mobile found");
			}
			while(rs.next()) {
				list.add(new MobileImpl(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4).toLocalDate()));
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

	
	public List<Mobile> searchMobileByModelNumber(String model) throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn = null;
		List<Mobile> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "SELECT model_no, company, price, MFGdate FROM mobile WHERE model_no = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, model);
			
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No mobile found");
			}
			while(rs.next()) {
				list.add(new MobileImpl(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4).toLocalDate()));
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
	

	public List<Mobile> searchMobileByPriceRange(int start, int end)throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn = null;
		List<Mobile> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "SELECT model_no, company, price, MFGdate FROM mobile WHERE price BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No mobile found");
			}
			while(rs.next()) {
				list.add(new MobileImpl(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4).toLocalDate()));
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
