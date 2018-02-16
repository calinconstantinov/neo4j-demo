package com.iquestgroup.neo4jdemo.service;

import com.iquestgroup.neo4jdemo.model.Movie;
import com.iquestgroup.neo4jdemo.model.queryresult.MovieAverageRatingData;
import com.iquestgroup.neo4jdemo.model.queryresult.MoviesCommonActorsData;

import java.util.List;

public interface MovieService {

  List<Movie> findMovies(int pageNumber, int pageSize);

  List<MoviesCommonActorsData> findMoviePairsWithMostCommonActors();

  MovieAverageRatingData findMovieAverageRatingData(String movieTitle);

  List<Movie> findMoviesToRecommend(String userName);

}
