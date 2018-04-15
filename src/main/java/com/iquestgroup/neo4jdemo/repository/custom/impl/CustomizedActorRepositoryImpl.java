package com.iquestgroup.neo4jdemo.repository.custom.impl;

import com.iquestgroup.neo4jdemo.model.Actor;
import com.iquestgroup.neo4jdemo.repository.custom.CustomizedActorRepository;
import org.neo4j.ogm.cypher.ComparisonOperator;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class CustomizedActorRepositoryImpl implements CustomizedActorRepository {

  @Autowired
  private Session session;

  @Override
  public Actor customFindByName(String name) {
    Collection<Actor> actors = session.loadAll(Actor.class,
        new Filter("name", ComparisonOperator.EQUALS, "emma"));
    return actors.iterator().next();
  }

}