package com.iquestgroup.neo4jdemo.repository;

import com.iquestgroup.neo4jdemo.model.Actor;
import com.iquestgroup.neo4jdemo.repository.custom.ActorRepositoryCustom;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends ActorRepositoryCustom, GraphRepository<Actor> {

  Actor findByName(String name);

}