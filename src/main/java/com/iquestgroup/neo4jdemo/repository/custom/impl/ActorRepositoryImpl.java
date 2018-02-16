package com.iquestgroup.neo4jdemo.repository.custom.impl;

import com.iquestgroup.neo4jdemo.model.Actor;
import com.iquestgroup.neo4jdemo.repository.ActorRepository;
import com.iquestgroup.neo4jdemo.repository.custom.ActorRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Repository;

public class ActorRepositoryImpl implements ActorRepositoryCustom {

  @Autowired
  private ActorRepository actorRepository;

  @Autowired
  private Neo4jOperations neo4jOperations;

  @Override
  public boolean checkFindByName(String name) {
    Actor actor1 = neo4jOperations.loadByProperty(Actor.class, "emma", name);
    Actor actor2 = actorRepository.findByName(name);
    return actor1.getName().equals(actor2.getName());
  }
}