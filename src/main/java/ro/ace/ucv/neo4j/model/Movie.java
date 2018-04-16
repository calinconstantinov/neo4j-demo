package ro.ace.ucv.neo4j.model;

import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

@NodeEntity(label = "Movie")
public class Movie {

  @Id
  @GeneratedValue
  private Long id;

  @Property
  private String title;

  @Relationship(type = "RATED", direction = Relationship.INCOMING)
  private Set<Rating> ratings = new HashSet<>();

  @Relationship(type = "ACTED_IN", direction = Relationship.INCOMING)
  private Set<Actor> actors = new HashSet<>();

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Set<Actor> getActors() {
    return actors;
  }

  public Set<Rating> getRatings() {
    return ratings;
  }

  public void setActors(Set<Actor> actors) {
    this.actors = actors;
    for (Actor actor : actors) {
      actor.getMovies().add(this);
    }
  }

}