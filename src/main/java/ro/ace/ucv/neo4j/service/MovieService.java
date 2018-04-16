package ro.ace.ucv.neo4j.service;

import ro.ace.ucv.neo4j.model.Movie;
import ro.ace.ucv.neo4j.model.queryresult.MovieAverageRatingData;
import ro.ace.ucv.neo4j.model.queryresult.MoviesCommonActorsData;

import java.util.List;

public interface MovieService {

  List<Movie> findMovies(int pageNumber, int pageSize);

  List<MoviesCommonActorsData> findMoviePairsWithMostCommonActors();

  MovieAverageRatingData findMovieAverageRatingData(String movieTitle);

  List<Movie> findMoviesToRecommend(String userName);

}
