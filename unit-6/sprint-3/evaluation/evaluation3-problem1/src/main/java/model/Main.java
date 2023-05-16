package model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ArtistService a = ctx.getBean("as", ArtistService.class);
		
		a.printArtworkMap();
		a.printArtistList();
		a.averageAgeOfArtistsWithArtworks(0);
		a.topArtistsByArtworks(0);
		a.topArtworksByCreationTime(0);
		
	}

}
