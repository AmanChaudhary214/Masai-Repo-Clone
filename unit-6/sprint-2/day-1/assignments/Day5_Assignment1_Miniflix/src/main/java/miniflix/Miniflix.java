package miniflix;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import miniflix.Config.MovieConfig;
import miniflix.Controller.MovieController;
import miniflix.Entity.Movie;

public class Miniflix {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MovieConfig.class);
		
		MovieController mController = ctx.getBean(MovieController.class);
		
		System.out.println(mController.addMovie(new Movie(5,"KGF 3","werw asdgawes", 120, 9.9)));
		
	}

}
