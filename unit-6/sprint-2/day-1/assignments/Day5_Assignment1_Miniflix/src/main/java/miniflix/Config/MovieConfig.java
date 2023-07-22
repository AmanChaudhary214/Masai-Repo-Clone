package miniflix.Config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import miniflix.Entity.Movie;
import miniflix.Entity.Series;

@Configuration
@ComponentScan(basePackages = "miniflix")
public class MovieConfig {

    @Bean
    public List<Movie> movieLists() {
    	
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1,"KGF","ABgsdfasef",2,9));
        movies.add(new Movie(2,"ABC","gsdljgwddsf",1,8.2));
        movies.add(new Movie(3,"XYZ","qwtesf",1,7.5));
        movies.add(new Movie(4,"IGF","werawe",3,8.1));
        
        return movies;
        
    }
    
    @Bean
    public List<Series> seriesLists() {
    	
        List<Series> series = new ArrayList<>();
        series.add(new Series(1,"KGF",2,"ssaf"));
        series.add(new Series(2,"ABC",1,"ssaf"));
        series.add(new Series(3,"XYZ",1,"ssaf"));
        series.add(new Series(4,"IGF",3,"ssaf"));
        
        return series;
        
    }

}
