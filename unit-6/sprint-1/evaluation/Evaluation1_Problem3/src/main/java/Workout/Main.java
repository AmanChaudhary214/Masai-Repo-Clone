package Workout;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		GymManager gymManager = ctx.getBean(GymManager.class, "gm");
		
		gymManager.displayDetails();
		
		ClassPathXmlApplicationContext ctx2 = (ClassPathXmlApplicationContext)ctx;
		ctx2.close();
	}

}
