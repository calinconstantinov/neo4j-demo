package com.iquestgroup.neo4jdemo.model;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "RATED")
public class Rating {

  @Id
  @GeneratedValue
  private Long id;

  @StartNode
  private User user;

  @EndNode
  private Movie movie;

  @Property
  private int stars;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Movie getMovie() {
    return movie;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public int getStars() {
    return stars;
  }

  public void setStars(int stars) {
    this.stars = stars;
  }

}
