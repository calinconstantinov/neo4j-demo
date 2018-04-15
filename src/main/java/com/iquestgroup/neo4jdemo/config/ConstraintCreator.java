package com.iquestgroup.neo4jdemo.config;

import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class ConstraintCreator {

  @Autowired
  private Session session;

  @PostConstruct
  public void postConstruct() {
    createConstraints();
  }

  @Transactional
  public void createConstraints() {
    try {
      session.query("CREATE CONSTRAINT ON (m:Movie) ASSERT m.title IS UNIQUE", null);
    } catch (Exception ex) {

    }
  }

}
