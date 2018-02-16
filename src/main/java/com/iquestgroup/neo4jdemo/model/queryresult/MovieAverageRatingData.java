package com.iquestgroup.neo4jdemo.model.queryresult;

import com.iquestgroup.neo4jdemo.model.Movie;
import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class MovieAverageRatingData {

  private Movie movie;

  private Double averageRating;

  public Movie getMovie() {
    return movie;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public Double getAverageRating() {
    return averageRating;
  }

  public void setAverageRating(Double averageRating) {
    this.averageRating = averageRating;
  }

}
