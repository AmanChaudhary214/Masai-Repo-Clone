package com.masai.day13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;

public class BookCRUDOperations {

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
	static void addBook(Scanner sc) throws SQLException, ClassNotFoundException {
		//create connection
		Connection conn = getConnectionToDatabase();
		
		//get an object of Statement
		Statement st = conn.createStatement();
		
		//code to take input
		System.out.print("Please enter bookId ");
		int bId = sc.nextInt();
		System.out.print("Please enter bookName ");
		String name = sc.next();
		System.out.print("Please enter bookPrice ");
		Double price = sc.nextDouble();
		System.out.print("Please enter bookAuthor ");
		String author = sc.next();
		System.out.print("Please enter publishYear ");
		String year = sc.next();
		
		//for the query
		String query = "INSERT INTO book VALUES(" + bId + ", '" + name +"', " + price + ", '" + author + "' , '" + year + "')";
		
		if (st.executeUpdate(query)>0) {
			System.out.println("Book added successfully");			
		}else {
			System.out.println("Not able to add Book");
		}
		
		closeConnection(conn);
	}
	
	static void updateBookAuthor(Scanner sc) throws SQLException, ClassNotFoundException {
		//create connection
		Connection conn = getConnectionToDatabase();
		
		//get an object of Statement
		Statement st = conn.createStatement();
		
		//code to take input
		System.out.print("Please enter bookId ");
		int bId = sc.nextInt();
		System.out.print("Please enter bookAuthor ");
		String author = sc.next();
		
		//for the query
		String query = "UPDATE book SET bookAuthor = '" + author + "' WHERE bookId = " + bId;
		
		if(st.executeUpdate(query) > 0) {
			System.out.println("Author updated successfully");
		}else {
			System.out.println("Not able to update author");
		}
		
		closeConnection(conn);
	}
	
	static void deleteBook(Scanner sc) throws SQLException, ClassNotFoundException {
		//create connection
		Connection conn = getConnectionToDatabase();
		
		//get an object of Statement
		Statement st = conn.createStatement();
		
		//code to take input
		System.out.print("Please enter bookId ");
		int bId = sc.nextInt();
		
		//for the query
		String query = "DELETE FROM book WHERE bookId = " + bId;
		
		if(st.executeUpdate(query) > 0) {
			System.out.println("Book deleted successfully");
		}else {
			System.out.println("Invalid Book Id");
		}
		
		closeConnection(conn);
	}
	
	//show list of customers
	static void printBookList() throws  SQLException, ClassNotFoundException{
		//create connection
		Connection conn = getConnectionToDatabase();

		//get an object of Statement
		Statement st = conn.createStatement();
		
		//for the query
		String query = "SELECT * FROM book";
		
		//use executeQuery not executeUpdate for SELECT statement
		ResultSet rs = st.executeQuery(query);
		
		//case-01: when resultset is empty
		if(!rs.isBeforeFirst() && rs.getRow() == 0) {
			//you are here means the resultset is empty
			System.out.println("No Book Found");
		}else {
			//you are here means the resultset has some records
			while(rs.next()) {
				System.out.println("bookId: " + rs.getInt(1) + " bookName: " + rs.getString(2) + " bookPrice: " + rs.getDouble(3) + " bookAuthor: " + rs.getString(4) + " publishYear: " + rs.getString(5));
			}
		}
		
		closeConnection(conn);
	}
	
	static void searchBookByPrice() throws  SQLException, ClassNotFoundException{
		//create connection
		Connection conn = getConnectionToDatabase();

		//get an object of Statement
		Statement st = conn.createStatement();
		
		//for the query
		String query = "SELECT * FROM book WHERE bookPrice BETWEEN " + 1000 + " AND " + 2000;
		
		//use executeQuery not executeUpdate for SELECT statement
		ResultSet rs = st.executeQuery(query);
		
		//case-01: when resultset is empty
		if(!rs.isBeforeFirst() && rs.getRow() == 0) {
			//you are here means the resultset is empty
			System.out.println("No Books available in this price range");
		}else {
			//you are here means the resultset has some records
			while(rs.next()) {
				System.out.println("bookId: " + rs.getInt(1) + " bookName: " + rs.getString(2) + " bookPrice: " + rs.getDouble(3) + " bookAuthor: " + rs.getString(4) + " publishYear: " + rs.getString(5));
			}
		}
		
		closeConnection(conn);
	}

	static void searchBookByAuthor(Scanner sc) throws  SQLException, ClassNotFoundException{
		//create connection
		Connection conn = getConnectionToDatabase();

		//get an object of Statement
		Statement st = conn.createStatement();
		
		//input of authorname
		System.out.print("Please enter bookAuthor ");
		String author = sc.next();
		
		//for the query
		String query = "SELECT * FROM book WHERE bookAuthor = '" + author + "'";
		
		//use executeQuery not executeUpdate for SELECT statement
		ResultSet rs = st.executeQuery(query);
		
		//case-01: when resultset is empty
		if(!rs.isBeforeFirst() && rs.getRow() == 0) {
			//you are here means the resultset is empty
			System.out.println("No Books available for this author");
		}else {
			//you are here means the resultset has some records
			while(rs.next()) {
				System.out.println("bookId: " + rs.getInt(1) + " bookName: " + rs.getString(2) + " bookPrice: " + rs.getDouble(3) + " bookAuthor: " + rs.getString(4) + " publishYear: " + rs.getString(5));
			}
		}
		
		closeConnection(conn);
	}
	
	static void bookPublishInYear(Scanner sc) throws  SQLException, ClassNotFoundException{
		//create connection
		Connection conn = getConnectionToDatabase();

		//get an object of Statement
		Statement st = conn.createStatement();
		
		//input of authorname
		System.out.print("Please enter year ");
		String year = sc.next();
		
		//for the query
		String query = "SELECT * FROM book WHERE publishYear = '" + year + "'";
		
		//use executeQuery not executeUpdate for SELECT statement
		ResultSet rs = st.executeQuery(query);
		
		//case-01: when resultset is empty
		if(!rs.isBeforeFirst() && rs.getRow() == 0) {
			//you are here means the resultset is empty
			System.out.println("No Books available for this author");
		}else {
			//you are here means the resultset has some records
			while(rs.next()) {
				System.out.println("bookId: " + rs.getInt(1) + " bookName: " + rs.getString(2) + " bookPrice: " + rs.getDouble(3) + " bookAuthor: " + rs.getString(4) + " publishYear: " + rs.getString(5));
			}
		}
		
		closeConnection(conn);
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int choice = 0;
		do {
			System.out.println("1. Add Book");
			System.out.println("2. Update Book Author");
			System.out.println("3. Delete Book");
			System.out.println("4. View Book List");
			System.out.println("5. Search Book By Price");
			System.out.println("6. Search Book By Author");
			System.out.println("5. Search Book By Year");
			System.out.println("0. Exit");
			
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					addBook(sc);
					break;
				case 2:
					updateBookAuthor(sc);
					break;
				case 3:
					deleteBook(sc);
					break;
				case 4:
					printBookList();
					break;
				case 5:
					searchBookByPrice();
					break;
				case 6:
					searchBookByAuthor(sc);
					break;
				case 7:
					bookPublishInYear(sc);
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
