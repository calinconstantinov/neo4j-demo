package com.iquestgroup.neo4jdemo.repository;

import com.iquestgroup.neo4jdemo.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends GraphRepository<User> {

  User findByName(String name);

  @Query("MATCH (movie:Movie {title:{movieTitle}})<-[:WATCHED]-(user) RETURN user")
  List<User> findUsersThatWatchedMovieFromTitle(@Param("movieTitle") String title);

}
