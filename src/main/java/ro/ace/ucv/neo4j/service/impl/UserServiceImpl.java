package ro.ace.ucv.neo4j.service.impl;

import ro.ace.ucv.neo4j.model.User;
import ro.ace.ucv.neo4j.repository.UserRepository;
import ro.ace.ucv.neo4j.service.UserService;
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
    return getUserRepository().findUsersThatWatchedMovieByTitle(title);
  }

  public UserRepository getUserRepository() {
    return userRepository;
  }

}
