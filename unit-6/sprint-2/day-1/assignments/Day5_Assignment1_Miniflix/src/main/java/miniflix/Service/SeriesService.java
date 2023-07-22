package miniflix.Service;

import java.util.List;

import miniflix.Entity.Series;

public interface SeriesService {

	List<Series> addSeries(Series series);

    Series removeSeries(int id);

    Series getMovieById(int id);

    List<Series> updateSeries(Series series);
	
}
