package com.masai.day13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CustomerCRUDOperations {
	
	/**
	 * Establish connection to the database
	 * @return Connection object that is handle for the connection with database
	 * @throws SQLException If some credentials are wrong, database not started, etc
	 * @throws ClassNotFoundException If driver class is not found
	 */	
	static Connection getConnectionToDatabase() throws SQLException, ClassNotFoundException {
		//step-1: load the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		//step-2
		ResourceBundle rb = ResourceBundle.getBundle("dbdetails");
		return DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
	}
	
	/**
	 * closes the connection with the database
	 * @param conn Connection object for which connection is to be closed
	 * @throws SQLException if anything goes wrong
	 */	
	static void closeConnection(Connection conn) throws SQLException {
		if (conn != null)
			conn.close();
	}
	
	/**
	 * Used to input customer details and add the same to database
	 * @param sc Scanner object that is used to take input
	 * @throws SQLException if anything goes wrong
	 * @throws ClassNotFoundException If driver class is not found
	 */
	static void addCustomer(Scanner sc) throws SQLException, ClassNotFoundException {
		//create connection
		Connection conn = getConnectionToDatabase();
		
		//get an object of Statement
		Statement st = conn.createStatement();
		
		//code to take input
		System.out.print("Please enter customerId ");
		String cId = sc.next();
		System.out.print("Please enter name ");
		String name = sc.next();
		System.out.print("Please enter gender ");
		String gender = sc.next();
		System.out.print("Please enter wallet balance ");
		Double wallet_balanace = sc.nextDouble();
		System.out.print("Please enter dob (YYYY-MM-DD) ");
		LocalDate doj = LocalDate.parse(sc.next());
		
		//for the query
		String query = "INSERT INTO customer VALUES('" + cId + "', '" + name +"', '" + gender + "', " + wallet_balanace + " , '" + doj + "')";
		
		//INSERT INTO customer VALUES('C001', 'Aman', 'M', 20000, '2006-05-06')
		if (st.executeUpdate(query)>0) {
			System.out.println("Customer added successfully");			
		}else {
			System.out.println("not able to add Customer");
		}
		
		closeConnection(conn);
	}
	
	static void updateCustomer(Scanner sc) throws SQLException, ClassNotFoundException {
		//create connection
		Connection conn = getConnectionToDatabase();
		
		//get an object of Statement
		Statement st = conn.createStatement();
		
		//code to take input
		System.out.print("Please enter customerId ");
		String cId = sc.next();
		System.out.print("Please enter name ");
		String name = sc.next();
		System.out.print("Please enter gender ");
		String gender = sc.next();
		System.out.print("Please enter wallet balance ");
		Double wallet_balanace = sc.nextDouble();
		System.out.print("Please enter dob (YYYY-MM-DD) ");
		LocalDate doj = LocalDate.parse(sc.next());
		
		//for the query
		String query = "UPDATE customer SET Name = '" + name + "', Gender = '" + gender + "', Wallet_Balance = " + wallet_balanace + ", Date_of_Joining = '" + doj + "' WHERE CustomerId = '" + cId + "'";
		
		if(st.executeUpdate(query) > 0) {
			System.out.println("Customer updated successfully");
		}else {
			System.out.println("Not able to update Customer");
		}
		
		closeConnection(conn);
	}
	
	static void deleteCustomer(Scanner sc) throws SQLException, ClassNotFoundException {
		//create connection
		Connection conn = getConnectionToDatabase();
		
		//get an object of Statement
		Statement st = conn.createStatement();
		
		//for the query
		String query = "DELETE FROM customer WHERE Wallet_Balanace = '" + 0.0 + "'";
		
		if(st.executeUpdate(query) > 0) {
			System.out.println("Customer deleted successfully");
		}else {
			System.out.println("Not able to delete customer");
		}
		
		closeConnection(conn);
	}
	
	//show list of customers
	static void printCustomerList() throws  SQLException, ClassNotFoundException{
		//create connection
		Connection conn = getConnectionToDatabase();

		//get an object of Statement
		Statement st = conn.createStatement();
		
		//for the query
		String query = "SELECT * FROM customer";
		
		//use executeQuery not executeUpdate for SELECT statement
		ResultSet rs = st.executeQuery(query);
		
		//case-01: when resultset is empty
		if(!rs.isBeforeFirst() && rs.getRow() == 0) {
			//you are here means the resultset is empty
			System.out.println("No customer Found");
		}else {
			//you are here means the resultset has some records
			while(rs.next()) {
				System.out.println("Customer ID: " + rs.getString(1) + " Name: " + rs.getString(2) + " Gender: " + rs.getString(3) + " Wallet Balance: " + rs.getDouble(4) + " Date of Joining: " + rs.getDate(5));
			}
		}
		
		closeConnection(conn);
	}
	
	//search customer by range of date_of_joining (i.e. who joined from 2023-01-01 to 2023-03-31)
	static void searchCustomerByJoiningDate(Scanner sc) throws  SQLException, ClassNotFoundException{
		//create connection
		Connection conn = getConnectionToDatabase();

		//get an object of Statement
		Statement st = conn.createStatement();
		
		//for the query
		String query = "SELECT * FROM customer WHERE Date_of_Joining BETWEEN '2023-01-01' AND '2023-03-31'";
		
		//use executeQuery not executeUpdate for SELECT statement
		ResultSet rs = st.executeQuery(query);
		
		//case-01: when resultset is empty
		if(!rs.isBeforeFirst() && rs.getRow() == 0) {
			//you are here means the resultset is empty
			System.out.println("No Customer Found");
		}else {
			//you are here means the resultset has some records
			while(rs.next()) {
				System.out.println("Customer ID: " + rs.getString(1) + " Name: " + rs.getString(2) + " Gender: " + rs.getString(3) + " Wallet Balance: " + rs.getDouble(4) + " Date of Joining: " + rs.getDate(5));
			}
		}
		
		closeConnection(conn);
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int choice = 0;
		do {
			System.out.println("1. Add Customer");
			System.out.println("2. Update Customer");
			System.out.println("3. Delete Customer");
			System.out.println("4. View Customer List");
			System.out.println("5. Search Customer By Date of Joining");
			System.out.println("0. Exit");
			
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					addCustomer(sc);
					break;
				case 2:
					updateCustomer(sc);
					break;
				case 3:
					deleteCustomer(sc);
					break;
				case 4:
					printCustomerList();
					break;
				case 5:
					searchCustomerByJoiningDate(sc);
					break;
				case 0:
					System.out.println("Thanks for using our services");
					break;
				default:
					System.out.println("Invalid Selection, try again later");
			}			
		}while(choice != 0);
		sc.close();
	}

}