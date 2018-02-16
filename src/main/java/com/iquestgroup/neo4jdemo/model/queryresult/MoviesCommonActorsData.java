package com.iquestgroup.neo4jdemo.model.queryresult;

import com.iquestgroup.neo4jdemo.model.Movie;
import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class MoviesCommonActorsData {

  private Movie movie1;

  private Movie movie2;

  private int noOfCommonActors;

  public Movie getMovie1() {
    return movie1;
  }

  public void setMovie1(Movie movie1) {
    this.movie1 = movie1;
  }

  public Movie getMovie2() {
    return movie2;
  }

  public void setMovie2(Movie movie2) {
    this.movie2 = movie2;
  }

  public int getNoOfCommonActors() {
    return noOfCommonActors;
  }

  public void setNoOfCommonActors(int noOfCommonActors) {
    this.noOfCommonActors = noOfCommonActors;
  }

}
