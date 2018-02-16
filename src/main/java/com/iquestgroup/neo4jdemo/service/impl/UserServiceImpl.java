package com.iquestgroup.neo4jdemo.service.impl;

import com.iquestgroup.neo4jdemo.model.User;
import com.iquestgroup.neo4jdemo.repository.UserRepository;
import com.iquestgroup.neo4jdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional
  public List<User> findUsersThatWatchedMovieFromTitle(String title) {
    return getUserRepository().findUsersThatWatchedMovieFromTitle(title);
  }

  public UserRepository getUserRepository() {
    return userRepository;
  }

}
