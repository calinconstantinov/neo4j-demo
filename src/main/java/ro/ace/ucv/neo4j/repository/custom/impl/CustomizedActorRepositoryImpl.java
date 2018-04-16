package ro.ace.ucv.neo4j.repository.custom.impl;

import org.neo4j.ogm.cypher.ComparisonOperator;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import ro.ace.ucv.neo4j.model.Actor;
import ro.ace.ucv.neo4j.repository.custom.CustomizedActorRepository;

import java.util.Collection;

public class CustomizedActorRepositoryImpl implements CustomizedActorRepository {

  @Autowired
  private Session session;

  @Override
  public Actor customFindByName(String name) {
    Collection<Actor> actors = session.loadAll(Actor.class,
        new Filter("name", ComparisonOperator.EQUALS, name));
    return actors.iterator().next();
  }

}