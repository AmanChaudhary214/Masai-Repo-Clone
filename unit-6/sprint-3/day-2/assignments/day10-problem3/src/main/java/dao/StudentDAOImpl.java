package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Student;

@Component
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	Connection c;

	@Override
	public String addStudent(Student s) {

		String res = "";

		try {
			PreparedStatement ps = c.prepareStatement("insert into Student values(?,?)");

			ps.setInt(1, s.getRollNo());
			ps.setString(2, s.getName());

			if (ps.executeUpdate() > 0) {
				res = "successful";
			} else {
				res = "unsuccessful";
				throw new RuntimeException(res);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;

	}

}
