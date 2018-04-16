package ro.ace.ucv.neo4j.service;

public interface PopulatingService {

  void deleteGraph();

  void populateManyMovies();

  void populateDb();

  void deleteAndPopulate();

}
