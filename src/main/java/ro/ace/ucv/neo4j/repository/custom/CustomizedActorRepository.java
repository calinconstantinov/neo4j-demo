package ro.ace.ucv.neo4j.repository.custom;

import ro.ace.ucv.neo4j.model.Actor;

public interface CustomizedActorRepository {

  Actor customFindByName(String name);

}
