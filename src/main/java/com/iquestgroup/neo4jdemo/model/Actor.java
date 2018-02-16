package com.iquestgroup.neo4jdemo.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity(label = "Actor")
public class Actor extends Person {

  @Relationship(type = "ACTED_IN", direction = Relationship.OUTGOING)
  private Set<Movie> movies = new HashSet<>();

  public Set<Movie> getMovies() {
    return movies;
  }

  public void actedIn(Set<Movie> movies) {
    this.movies = movies;
    for (Movie movie : movies) {
      movie.getActors().add(this);
    }
  }

}
