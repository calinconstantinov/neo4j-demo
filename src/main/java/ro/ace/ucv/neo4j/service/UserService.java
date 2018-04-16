package ro.ace.ucv.neo4j.service;

import ro.ace.ucv.neo4j.model.User;

import java.util.List;

public interface UserService {

  List<User> findUsersThatWatchedMovieFromTitle(String title);

}
