package useCases;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Config;
import model.Student;

public class AddStudent {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		StudentDAO st = context.getBean(StudentDAOImpl.class);

		Student s = new Student();

		s.setRollNo(1);
		s.setName("Aman");

		System.out.println(st.addStudent(s));

		((AnnotationConfigApplicationContext) context).close();

	}

}
