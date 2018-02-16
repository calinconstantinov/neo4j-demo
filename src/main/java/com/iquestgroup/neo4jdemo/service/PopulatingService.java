package com.iquestgroup.neo4jdemo.service;

public interface PopulatingService {

  void deleteGraph();

  void populateManyMovies();

  void populateDb();

  void deleteAndPopulate();

}
