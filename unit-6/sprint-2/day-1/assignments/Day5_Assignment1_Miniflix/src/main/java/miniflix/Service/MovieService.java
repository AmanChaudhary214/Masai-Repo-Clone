package miniflix.Service;

import java.util.List;

import miniflix.Entity.Movie;

public interface MovieService {

	List<Movie> addMovie(Movie movie);

    List<Movie> removeMovieById(int id);

    Movie getMovieById(int id);

    List<Movie> updateMovie(Movie movie);
	
}
