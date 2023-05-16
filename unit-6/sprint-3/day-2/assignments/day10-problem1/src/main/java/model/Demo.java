package model;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Demo {

	@Autowired
//	@Qualifier(value = "city")
	List<String> cities;

	@Autowired
//	@Qualifier(value = "st")
	List<Student> student;

	@PostConstruct
	public void initMethod() {
		System.out.println("inside init");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("inside close method");
	}

	public void showDetails() {
		System.out.println(cities);
		System.out.println(student);
	}
}
