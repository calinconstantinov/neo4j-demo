package com.iquestgroup.neo4jdemo.service;

import com.iquestgroup.neo4jdemo.model.User;

import java.util.List;

public interface UserService {

  List<User> findUsersThatWatchedMovieFromTitle(String title);

}
