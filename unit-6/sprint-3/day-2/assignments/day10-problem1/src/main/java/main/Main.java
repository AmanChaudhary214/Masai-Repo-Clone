package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import model.Config;
import model.Demo;

public class Main {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

		Demo d1 = ctx.getBean(Demo.class);

		d1.showDetails();

		AnnotationConfigApplicationContext ctx2 = (AnnotationConfigApplicationContext) ctx;

		ctx2.close();
	}

}
