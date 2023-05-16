package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Car;
import com.masai.dto.CarImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class CarDAOImpl implements CarDAO {

	@Override
	public void addCar(Car car) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtility.getConnectiontoDatabase();
			String query = "INSERT INTO car(car_id, model_name, price, total_seats, company_id) VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, car.getCarId());
			ps.setString(2, car.getModel());
			ps.setInt(3, car.getPrice());
			ps.setInt(4, car.getSeats());
			ps.setString(5, car.getcId());
			
			ps.executeUpdate();

		}catch (ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to add car details");
		}finally {
			try {
				DBUtility.closeConnection(conn);
			}catch (SQLException ex) {
				
			}
		}
	}


	@Override
	public void updateCar(Car car) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtility.getConnectiontoDatabase();
			String query = "update car SET model_name = ?, price = ?, total_seats = ?, company_id = ? WHERE car_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, car.getModel());
			ps.setInt(2, car.getPrice());
			ps.setInt(3, car.getSeats());
			ps.setString(4, car.getcId());
			ps.setString(5, car.getCarId());
			
			ps.executeUpdate();
		}catch (ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to add car details");
		}finally {
			try {
				DBUtility.closeConnection(conn);
			}catch (SQLException ex) {
				
			}
		}
	}
	

	@Override
	public void deleteCar(String carId) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DBUtility.getConnectiontoDatabase();
			String query = "DELETE from car WHERE car_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, carId);
			
			ps.executeUpdate();

		}catch (ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to delete car details");
		}finally {
			try {
				DBUtility.closeConnection(conn);
			}catch (SQLException ex) {
				
			}
		}
	}
	

	@Override
	public List<String> displayCar() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		Connection conn = null;
		List<String> list = new ArrayList<>();
		try {
			conn = DBUtility.getConnectiontoDatabase();
			String query = "SELECT car_id, model_name, price, total_seats, company_name, turnover_in_crores FROM company p JOIN car c ON c.company_id = p.company_id";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			if(DBUtility.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No data found");
			}
			while(rs.next()) {
				String str = "Car Id: " + rs.getString(1) + " Model Name: " + rs.getString(2) + " Price: " + rs.getString(3) + " Total Seats: " + rs.getString(4)
				+ " Company Name : " + rs.getString(5) + " Turnover: " + rs.getString(6);
				list.add(str);
			}

		}catch (ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to delete car details");
		}finally {
			try {
				DBUtility.closeConnection(conn);
			}catch (SQLException ex) {
				
			}
		}
		return list;
	}
}
