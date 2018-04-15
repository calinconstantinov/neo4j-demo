package com.iquestgroup.neo4jdemo.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public abstract class DomainObject {

  @Id
  @GeneratedValue
  protected Long id;

  public Long getId() {
    return id;
  }

}
