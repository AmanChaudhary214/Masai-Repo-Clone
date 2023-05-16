package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "dao" })
public class Config {

	@Bean
	public Connection getConnection() {

		Connection c = null;

		ResourceBundle rb = ResourceBundle.getBundle("dbdetails");

		try {
			Class.forName(rb.getString("class"));

			c = DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));

			return c;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return c;

	}

}
