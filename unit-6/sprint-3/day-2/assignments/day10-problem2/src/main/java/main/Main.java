package main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import model.Config;
import model.Travel;

public class Main {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

		Travel travel = ctx.getBean(Travel.class);

		travel.startJourney();

		AnnotationConfigApplicationContext ctx2 = ((AnnotationConfigApplicationContext) ctx);
		ctx2.close();

		System.gc();

	}
}
