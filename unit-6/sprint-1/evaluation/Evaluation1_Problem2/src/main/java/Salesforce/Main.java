package Salesforce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Service service = ctx.getBean(Service.class, "ser");
		
		service.demoMethod();
	}

}
