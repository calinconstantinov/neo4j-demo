package ro.ace.ucv.neo4j.service.impl;

import ro.ace.ucv.neo4j.model.Movie;
import ro.ace.ucv.neo4j.model.queryresult.MovieAverageRatingData;
import ro.ace.ucv.neo4j.model.queryresult.MoviesCommonActorsData;
import ro.ace.ucv.neo4j.repository.MovieRepository;
import ro.ace.ucv.neo4j.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

  @Autowired
  private MovieRepository movieRepository;

  @Override
  @Transactional
  public List<Movie> findMovies(int pageNumber, int pageSize) {
    PageRequest pageRequest = PageRequest.of(3, 10, Sort.Direction.ASC, "title");
    Page<Movie> moviePage = getMovieRepository().findAll(pageRequest);
    return moviePage.getContent();
  }

  @Override
  @Transactional
  public List<MoviesCommonActorsData> findMoviePairsWithMostCommonActors() {
    return getMovieRepository().findMoviePairsWithMostCommonActors();
  }

  @Override
  @Transactional
  public MovieAverageRatingData findMovieAverageRatingData(String movieTitle) {
    return getMovieRepository().findMovieAverageRatingData(movieTitle);
  }

  @Override
  @Transactional
  public List<Movie> findMoviesToRecommend(String userName) {
    return getMovieRepository().findMoviesToRecommend(userName);
  }

  public MovieRepository getMovieRepository() {
    return movieRepository;
  }

}
