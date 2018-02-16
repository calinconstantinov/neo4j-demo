package com.iquestgroup.neo4jdemo.model;

import org.neo4j.ogm.annotation.GraphId;

public abstract class DomainObject {

  @GraphId
  protected Long id;

  public Long getId() {
    return id;
  }

}
