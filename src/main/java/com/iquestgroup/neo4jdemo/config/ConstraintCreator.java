package com.iquestgroup.neo4jdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ConstraintCreator {

  @Autowired
  private Neo4jOperations neo4jOperations;

  @PostConstruct
  public void postConstruct() {
    createConstraints();
  }

  public void createConstraints() {
    try {
      neo4jOperations.query("CREATE CONSTRAINT ON (m:Movie) ASSERT m.title IS UNIQUE", null);
    } catch (Exception ex) {

    }
  }

}
