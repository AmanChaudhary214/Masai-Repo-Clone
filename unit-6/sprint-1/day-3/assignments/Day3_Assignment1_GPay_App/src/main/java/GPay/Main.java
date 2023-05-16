package GPay;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		PaymentPresentation pp = ctx.getBean("pip", PaymentPresentation.class);
		
		pp.payment();
	}

}
