package ro.ace.ucv.neo4j.model;

import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

@NodeEntity(label = "Actor")
public class Actor {

  @Id
  @GeneratedValue
  private Long id;

  @Property
  private String name;

  @Relationship(type = "ACTED_IN", direction = Relationship.OUTGOING)
  private Set<Movie> movies = new HashSet<>();

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Movie> getMovies() {
    return movies;
  }

  public void setMovies(Set<Movie> movies) {
    this.movies = movies;
    for (Movie movie : movies) {
      movie.getActors().add(this);
    }
  }

}
