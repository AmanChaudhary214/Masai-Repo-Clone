package miniflix.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import miniflix.Entity.Movie;

@Repository
public class MoviesDAO {

	@Autowired
	public List<Movie> movieList;
	

	public List<Movie> findAll() {
		return movieList;
	}
	

	public Movie findById(int id) {
		
		for(int i=0; i<movieList.size(); i++){
			if(movieList.get(i).getId() == id){
				return movieList.get(i);
			}
		}
		return null;
		
	}
	

	public List<Movie> delete(int id) {
		
		for (int i=0; i < movieList.size(); i++) {
			if(movieList.get(i).getId() == id){
				movieList.remove(i);
			}
		}
		return movieList;
		
	}
	
	
	public List<Movie> add(Movie movie) {
		
		movieList.add(movie);
		return movieList;
		
	}
	
}
