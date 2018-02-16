package com.iquestgroup.neo4jdemo.service.impl;

import com.iquestgroup.neo4jdemo.repository.ActorRepository;
import com.iquestgroup.neo4jdemo.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl implements ActorService {

  @Autowired
  private ActorRepository actorRepository;

  public ActorRepository getActorRepository() {
    return actorRepository;
  }

}
