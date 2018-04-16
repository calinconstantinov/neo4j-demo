package ro.ace.ucv.neo4j.model;

import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

@NodeEntity(label = "User")
public class User {

  @Id
  @GeneratedValue
  private Long id;

  @Property
  private String name;

  @Relationship(type = "WATCHED")
  private Set<Movie> moviesWatched = new HashSet<>();

  @Relationship(type = "RATED")
  private Set<Rating> ratings = new HashSet<>();

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

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
