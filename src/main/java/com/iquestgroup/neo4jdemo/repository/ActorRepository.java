package com.iquestgroup.neo4jdemo.repository;

import com.iquestgroup.neo4jdemo.model.Actor;
import com.iquestgroup.neo4jdemo.repository.custom.CustomizedActorRepository;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends Neo4jRepository<Actor, Long>, CustomizedActorRepository {

  Actor findByName(String name);

}