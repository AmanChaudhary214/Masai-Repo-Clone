package miniflix.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import miniflix.Entity.Series;
import miniflix.Service.SeriesService;

@Controller
public class SeriesController {

    @Autowired
    private SeriesService series;

    public List<Series> addSeries(Series ser) {
        return series.addSeries(ser);
    }

    public Series removeSeries(int id) {
        return series.removeSeries(id);
    }

    public Series getMovieById(int id) {
        return series.getMovieById(id);
    }

    public List<Series> updateSeries(Series Series) {
        return series.updateSeries(Series);
    }
}
