package com.iquestgroup.neo4jdemo.repository.custom.impl;

import com.iquestgroup.neo4jdemo.repository.custom.HelperGraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class HelperGraphRepositoryImpl implements HelperGraphRepository {

  @Autowired
  private Neo4jOperations neo4jOperations;

  @Override
  public void deleteGraph() {
    neo4jOperations.query("MATCH (n) DETACH DELETE n;", new HashMap<>());
  }

}
