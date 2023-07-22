package miniflix.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniflix.Entity.Movie;
import miniflix.Repository.MoviesDAO;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MoviesDAO moviesDAO;

	@Override
	public List<Movie> addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return moviesDAO.add(movie);
	}

	@Override
	public List<Movie> removeMovieById(int id) {
		// TODO Auto-generated method stub
		return moviesDAO.delete(id);
	}

	@Override
	public Movie getMovieById(int id) {
		// TODO Auto-generated method stub
		return moviesDAO.findById(id);
	}

	@Override
	public List<Movie> updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		moviesDAO.delete(movie.getId());
		moviesDAO.add(movie);
		return moviesDAO.findAll();
	}

}
