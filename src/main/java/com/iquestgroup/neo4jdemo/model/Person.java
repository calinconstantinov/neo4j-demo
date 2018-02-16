package com.iquestgroup.neo4jdemo.model;

import org.neo4j.ogm.annotation.Property;

public abstract class Person extends DomainObject {

  @Property
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
