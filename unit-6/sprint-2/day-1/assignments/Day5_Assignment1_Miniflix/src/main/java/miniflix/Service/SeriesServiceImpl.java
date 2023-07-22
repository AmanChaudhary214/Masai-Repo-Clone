package miniflix.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import miniflix.Entity.Series;
import miniflix.Repository.SeriesDAO;

@Service
public class SeriesServiceImpl implements SeriesService {
	
	@Autowired
	private SeriesDAO seriesDAO;

	@Override
	public List<Series> addSeries(Series series) {
		// TODO Auto-generated method stub
		return seriesDAO.add(series);
	}

	@Override
	public Series removeSeries(int id) {
		// TODO Auto-generated method stub
		return seriesDAO.delete(id);
	}

	@Override
	public Series getMovieById(int id) {
		// TODO Auto-generated method stub
		return seriesDAO.findById(id);
	}

	@Override
	public List<Series> updateSeries(Series series) {
		// TODO Auto-generated method stub
		seriesDAO.delete(series.getId());
		seriesDAO.add(series);
		return seriesDAO.findAll();
	}

}
