package miniflix.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import miniflix.Entity.Series;

@Repository
public class SeriesDAO{
	
	@Autowired
	List<Series> seriesList;

	public List<Series> findAll() {
	    return seriesList;
	}
	
	
	public Series findById(int id) {
	    for (int i=0; i<seriesList.size(); i++) {
	    	if (seriesList.get(i).getId() == id) {
	    		return seriesList.get(i);
	    	}
	    }
		return null;
	}
	
	
	public Series delete(int id) {
		for (int i=0; i<seriesList.size(); i++) {
	    	if (seriesList.get(i).getId() == id) {
	    		Series deletedSeries =  seriesList.get(i);
	    		seriesList.remove(i);
	    		return deletedSeries;
	    	}
	    }
		return null;
	}
	
	
	public List<Series> add(Series series) {
	    seriesList.add(series);
		return seriesList;
	}
	
}
