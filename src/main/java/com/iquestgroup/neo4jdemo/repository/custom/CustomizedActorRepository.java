package com.iquestgroup.neo4jdemo.repository.custom;

import com.iquestgroup.neo4jdemo.model.Actor;

public interface CustomizedActorRepository {

  Actor customFindByName(String name);

}