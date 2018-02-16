package com.iquestgroup.neo4jdemo.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class User extends Person {

  @Relationship(type = "WATCHED", direction = Relationship.OUTGOING)
  private Set<Movie> moviesWatched = new HashSet<>();

  @Relationship(type = "RATED")
  private Set<Rating> ratings = new HashSet<>();

  public Set<Movie> getMoviesWatched() {
    return moviesWatched;
  }

  public void setMoviesWatched(Set<Movie> moviesWatched) {
    this.moviesWatched = moviesWatched;
  }

  public Set<Rating> getRatings() {
    return ratings;
  }

  public void setRatings(Set<Rating> ratings) {
    this.ratings = ratings;
  }

}
