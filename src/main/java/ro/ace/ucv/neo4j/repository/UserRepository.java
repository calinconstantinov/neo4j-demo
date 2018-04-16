package ro.ace.ucv.neo4j.repository;

import ro.ace.ucv.neo4j.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {

  User findByName(String name);

  @Query("MATCH (movie:Movie {title:{movieTitle}})<-[:WATCHED]-(user) RETURN user")
  List<User> findUsersThatWatchedMovieByTitle(@Param("movieTitle") String title);

}
