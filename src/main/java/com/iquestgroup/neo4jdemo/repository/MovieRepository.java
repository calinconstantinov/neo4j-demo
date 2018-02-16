package com.iquestgroup.neo4jdemo.repository;

import com.iquestgroup.neo4jdemo.model.Movie;
import com.iquestgroup.neo4jdemo.model.queryresult.MovieAverageRatingData;
import com.iquestgroup.neo4jdemo.model.queryresult.MoviesCommonActorsData;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends GraphRepository<Movie> {

  // returns the node with id equal to idOfMovie parameter.
  @Query("MATCH (n) WHERE id(n)={0} RETURN n")
  Movie findMovieFromId(Integer nodeIdOfMovie);

  @Query("MATCH (movie:Movie {title:{0}}) RETURN movie")
  Movie findMovieFromTitle(String movieTitle);

  // returns pairs of movies that share the largest number of common actors.
  @Query("MATCH (movie1:Movie)<-[acted1:ACTED_IN]-(actor:Actor)-[acted2:ACTED_IN]->(movie2:Movie) " +
      "WHERE ID(movie1) < ID(movie2) RETURN movie1, movie2, count(actor) as noOfCommonActors " +
      "ORDER BY noOfCommonActors DESC")
  List<MoviesCommonActorsData> findMoviePairsWithMostCommonActors();

  @Query("MATCH (movie:Movie)<-[r:RATED]-() WHERE movie.title={0} " +
      "RETURN movie, AVG(r.stars) AS averageRating")
  MovieAverageRatingData findMovieAverageRatingData(String movieTitle);

  // considering the movies that the given user has rated, recommends movies ordered by their average rank
  // that users that have rated the same movies as the given user have watched, but the given user has not.
  @Query("MATCH (user:User)-[:RATED]->(movie:Movie)<-[:RATED]-(otherUser:User)-[:WATCHED]->(movieToRecommend:Movie) " +
      "WHERE user.name={0} AND NOT (user)-[:WATCHED]->(movieToRecommend) WITH DISTINCT movieToRecommend" +
      " MATCH (movieToRecommend)<-[rating:RATED]-()" +
      " RETURN movieToRecommend, avg(rating.stars) as rating ORDER BY rating DESC")
  List<Movie> findMoviesToRecommend(String userName);

}
