package miniflix.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import miniflix.Entity.Movie;
import miniflix.Service.MovieService;

@Controller
public class MovieController {

    @Autowired
    private MovieService movie;

    public List<Movie> addMovie(Movie mov) {
        return movie.addMovie(mov);
    }

    public List<Movie> removeMovie(int id) {
        return movie.removeMovieById(id);
    }


    public Movie getMovieById(int id) {
        return movie.getMovieById(id);
    }


    public List<Movie> updateMovie(Movie mov) {
        return movie.updateMovie(mov);
    }
    
}
