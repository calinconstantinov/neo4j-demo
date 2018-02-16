package com.iquestgroup.neo4jdemo.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity(label = "Movie")
public class Movie extends DomainObject {

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

  public void actedIn(Set<Actor> actors) {
    this.actors = actors;
    for (Actor actor : actors) {
      actor.getMovies().add(this);
    }
  }

}