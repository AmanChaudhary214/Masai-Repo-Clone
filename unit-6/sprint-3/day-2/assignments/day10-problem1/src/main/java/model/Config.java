package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = "model")
@PropertySource("cities.properties")
public class Config {

	@Autowired
	Environment env;
	
	@Bean
	public List<String> getCities() {
		List<String> city = new ArrayList<>();
		
		city.add(env.getProperty("c1"));
		city.add(env.getProperty("c2"));
		city.add(env.getProperty("c3"));
		city.add(env.getProperty("c4"));
		city.add(env.getProperty("c5"));
		
		return city;
	}

	@Bean
	public List<Student> getStudent() {
		List<Student> st = new ArrayList<>();
		
		st.add(new Student(1, "aman"));
		st.add(new Student(2, "neha"));
		st.add(new Student(3, "hemant"));
		st.add(new Student(4, "karan"));
		st.add(new Student(5, "vishal"));
		
		return st;
	}
}
