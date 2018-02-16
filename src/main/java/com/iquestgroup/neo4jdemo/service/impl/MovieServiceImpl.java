package com.iquestgroup.neo4jdemo.service.impl;

import com.iquestgroup.neo4jdemo.model.Movie;
import com.iquestgroup.neo4jdemo.model.queryresult.MovieAverageRatingData;
import com.iquestgroup.neo4jdemo.model.queryresult.MoviesCommonActorsData;
import com.iquestgroup.neo4jdemo.repository.MovieRepository;
import com.iquestgroup.neo4jdemo.service.MovieService;
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
    PageRequest pageRequest = new PageRequest(3, 10, Sort.Direction.ASC, "title");
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
