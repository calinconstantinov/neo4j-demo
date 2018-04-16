package ro.ace.ucv.neo4j.repository;

import ro.ace.ucv.neo4j.model.Actor;
import ro.ace.ucv.neo4j.repository.custom.CustomizedActorRepository;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends Neo4jRepository<Actor, Long>, CustomizedActorRepository {

  Actor findByName(String name);

}
