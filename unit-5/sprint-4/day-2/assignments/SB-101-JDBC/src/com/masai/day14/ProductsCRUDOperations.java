package com.masai.day14;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ProductsCRUDOperations {

	/**
	 * Establish connection to the database
	 * @return Connection object that is handle for the connection with database
	 * @throws SQLException If some credentials are wrong, database not started etc ect
	 * @throws ClassNotFoundException If driver class is not found
	 */
	static Connection getConnectionTodatabase() throws SQLException, ClassNotFoundException {
		//step-1: load the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		//step-2
		ResourceBundle rb = ResourceBundle.getBundle("dbdetails");
		return DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
	}
	
	/**
	 * close the connection with the database
	 * @param conn Connection object for which connection is to be closed
	 * @throws SQLException if anything goes wrong
	 */
	static void closeConnection(Connection conn) throws SQLException {
		if(conn != null)
			conn.close();
	}
	
	/**
	 * To add employee by taking information input from user
	 * @param sc: object of Scanner class to take input
	 */
	static void addProduct(Scanner sc) {
		//step-01: Make Connection with Database
		Connection conn = null;
		try {
			conn = getConnectionTodatabase();
			
			//step-02 Frame query
			String query = "INSERT INTO product (pid, pname, quantity, price) VALUES (?, ?, ?, ?)";
			
			//step-03 take an object of PreparaedStatement
			PreparedStatement ps = conn.prepareStatement(query);
			
			//step-04 Take data input
			System.out.print("Enter product id ");
			int eid = sc.nextInt();
			
			System.out.print("Enter product name ");
			String name = sc.next();
			
			System.out.print("Enter quantity ");
			int quantity = sc.nextInt();
			
			System.out.print("Enter price ");
			int price = sc.nextInt();
			
			//step-04: data stuffing
			ps.setInt(1, eid);
			ps.setString(2, name);
			ps.setInt(3, quantity);
			ps.setInt(4, price);
			
			if(ps.executeUpdate() > 0) {
				System.out.println("Product added successfully");
			}else {
				System.out.println("Unable to add product");
			}
		}catch(ClassNotFoundException | SQLException ex) {
			System.out.println(ex);
		}finally {
			if(conn != null) {
				try {
					closeConnection(conn);
				}catch(SQLException ex) {
					
				}
			}
		}
	}
	
	static void updateProduct(Scanner sc) {
		//step-01: Make Connection with Database
		Connection conn = null;
		try {
			conn = getConnectionTodatabase();
			
			//step-02 Frame query
			String query = "UPDATE product SET quantity = ?, price = ? WHERE pid = ?";
			
			//step-03 take an object of PreparaedStatement
			PreparedStatement ps = conn.prepareStatement(query);
			
			//step-04 Take data input
			System.out.print("Enter product id ");
			int pid = sc.nextInt();
			
			System.out.print("Enter quantity ");
			int quantity = sc.nextInt();
			
			System.out.print("Enter price ");
			int price = sc.nextInt();
			
			//step-04: data stuffing
			ps.setInt(3, pid);
			ps.setInt(1, quantity);
			ps.setInt(2, price);
			
			//System.out.println(ps);
			if(ps.executeUpdate() > 0) {
				System.out.println("Product updated successfully");
			}else {
				System.out.println("Unable to update product");
			}
		}catch(ClassNotFoundException | SQLException ex) {
			System.out.println(ex);
		}finally {
			if(conn != null) {
				try {
					closeConnection(conn);
				}catch(SQLException ex) {
					
				}
			}
		}
	}
	
	static void deleteProduct(Scanner sc) {
		//step-01: Make Connection with Database
		Connection conn = null;
		try {
			conn = getConnectionTodatabase();
			
			//step-02 Frame query
			String query = "DELETE FROM product WHERE quantity < 2";
			
			//step-03 take an object of PreparaedStatement
			PreparedStatement ps = conn.prepareStatement(query);
			
			//System.out.println(ps);
			if(ps.executeUpdate() > 0) {
				System.out.println("Product deleted successfully");
			}else {
				System.out.println("Unable to delete product");
			}
		}catch(ClassNotFoundException | SQLException ex) {
			System.out.println(ex);
		}finally {
			if(conn != null) {
				try {
					closeConnection(conn);
				}catch(SQLException ex) {
					
				}
			}
		}
	}
	
	static void viewProduct() {
		//step-01: Make Connection with Database
		Connection conn = null;
		try {
			conn = getConnectionTodatabase();
			
			//step-02 Frame query
			String query = "SELECT pid, pname, quantity, price from product";
			
			//step-03 take an object of PreparaedStatement
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst() && rs.getRow() == 0) {
				//you are here means no employee in the database
				System.out.println("No Product Found");
			}else{
				while(rs.next()) {
					System.out.print("Product Id: " + rs.getInt(1));
					System.out.print(" Product Name: " + rs.getString(2));
					System.out.print(" Quantity: " + rs.getInt(3));
					System.out.println(" Price: " + rs.getInt(4));
				}
			}
			
		}catch(ClassNotFoundException | SQLException ex) {
			System.out.println(ex);
		}finally {
			if(conn != null) {
				try {
					closeConnection(conn);
				}catch(SQLException ex) {
					
				}
			}
		}
	}
	
	static void searchProductByName(Scanner sc) {
		//step-01: Make Connection with Database
		Connection conn = null;
		try {
			conn = getConnectionTodatabase();
			
			//step-02 Frame query
			String query = "SELECT pid, pname, quantity, price FROM product WHERE pname = ?";
			
			//step-03 take an object of PreparaedStatement
			PreparedStatement ps = conn.prepareStatement(query);
			
			System.out.print("Please enter name ");
			String name = sc.next();
			
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst() && rs.getRow() == 0) {
				//you are here means no employee in the database
				System.out.println("No Product Found");
			}else{
				while(rs.next()) {
					System.out.print("Product Id: " + rs.getInt(1));
					System.out.print(" Product Name: " + rs.getString(2));
					System.out.print(" Quantity: " + rs.getInt(3));
					System.out.println(" Price: " + rs.getInt(4));
				}
			}
			
		}catch(ClassNotFoundException | SQLException ex) {
			System.out.println(ex);
		}finally {
			if(conn != null) {
				try {
					closeConnection(conn);
				}catch(SQLException ex) {
					
				}
			}
		}
	}
	
	static void searchEmployeeByPriceRange(Scanner sc) {
		//step-01: Make Connection with Database
		Connection conn = null;
		try {
			conn = getConnectionTodatabase();
			
			//step-02 Frame query
			String query = "SELECT pid, pname, quantity, price FROM product WHERE price BETWEEN ? AND ?";
			
			//step-03 take an object of PreparaedStatement
			PreparedStatement ps = conn.prepareStatement(query);
			
			System.out.print("Please enter start price ");
			int startPrice = sc.nextInt();
			System.out.print("Please enter end price ");
			int endPrice = sc.nextInt();
			
			ps.setInt(1, startPrice);
			ps.setInt(2, endPrice);
			
			ResultSet rs = ps.executeQuery();
			
			if(!rs.isBeforeFirst() && rs.getRow() == 0) {
				//you are here means no employee in the database
				System.out.println("No Employee Found");
			}else{
				while(rs.next()) {
					System.out.print("Product Id: " + rs.getInt(1));
					System.out.print(" Product Name: " + rs.getString(2));
					System.out.print(" Quantity: " + rs.getInt(3));
					System.out.println(" Price: " + rs.getInt(4));
				}
			}
			
		}catch(ClassNotFoundException | SQLException ex) {
			System.out.println(ex);
		}finally {
			if(conn != null) {
				try {
					closeConnection(conn);
				}catch(SQLException ex) {
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("0. Exit");
			System.out.println("1. Add Product");
			System.out.println("2. View Product");
			System.out.println("3. Update Product");
			System.out.println("4. Delete Product");
			System.out.println("5. Search Product By Name");
			System.out.println("6. Search Product By Price Range");
			System.out.print("Enter Selection ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					addProduct(sc);
					break;
				case 2:
					viewProduct();
					break;
				case 3:
					updateProduct(sc);
					break;
				case 4:
					deleteProduct(sc);
					break;
				case 5:
					searchProductByName(sc);
					break;
				case 6:
					searchEmployeeByPriceRange(sc);
					break;
				case 0:
					System.out.println("Bye Bye");
					break;
				default:
					System.out.println("Invalid Selection please try again later");
					break;
			}
			
		}while(choice != 0);
		sc.close();
	}
}
