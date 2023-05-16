package Tour_Package;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		HolidayPackage hPackage = ctx.getBean("hp1", HolidayPackage.class);
		
		hPackage.showDetails();
	
	}

}
