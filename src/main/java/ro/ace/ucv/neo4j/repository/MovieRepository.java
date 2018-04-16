package ro.ace.ucv.neo4j.repository;

import ro.ace.ucv.neo4j.model.Movie;
import ro.ace.ucv.neo4j.model.queryresult.MovieAverageRatingData;
import ro.ace.ucv.neo4j.model.queryresult.MoviesCommonActorsData;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {

  // returns the node with id equal to idOfMovie parameter.
  @Query("MATCH (n) WHERE id(n)={0} RETURN n")
  Movie findMovieFromId(Integer nodeIdOfMovie);

  @Query("MATCH (movie:Movie {title:{0}}) RETURN movie")
  Movie findMovieFromTitle(String movieTitle);

  // returns pairs of movies that share the largest number of common actors.
  @Query("MATCH (movie1:Movie)<-[acted1:ACTED_IN]-(actor:Actor)-[acted2:ACTED_IN]->(movie2:Movie) " +
      "WHERE id(movie1) < id(movie2) RETURN movie1, movie2, count(actor) AS noOfCommonActors " +
      "ORDER BY noOfCommonActors DESC")
  List<MoviesCommonActorsData> findMoviePairsWithMostCommonActors();

  @Query("MATCH (movie:Movie)<-[r:RATED]-() WHERE movie.title={0} " +
      "RETURN movie, avg(r.stars) AS averageRating")
  MovieAverageRatingData findMovieAverageRatingData(String movieTitle);

  // considering the movies that the given user has rated, recommends movies ordered by their average rank
  // that users that have rated the same movies as the given user have watched, but the given user has not.
  @Query("MATCH (user:User)-[:RATED]->(movie:Movie)<-[:RATED]-(otherUser:User)-[:WATCHED]->(movieToRecommend:Movie) " +
      "WHERE user.name={0} AND NOT (user)-[:WATCHED]->(movieToRecommend) WITH DISTINCT movieToRecommend" +
      " MATCH (movieToRecommend)<-[rating:RATED]-()" +
      " RETURN movieToRecommend, avg(rating.stars) AS rating ORDER BY rating DESC")
  List<Movie> findMoviesToRecommend(String userName);

}
