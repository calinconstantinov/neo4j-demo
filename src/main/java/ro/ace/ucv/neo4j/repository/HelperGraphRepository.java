package ro.ace.ucv.neo4j.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelperGraphRepository extends Neo4jRepository {

  @Query("MATCH (n) DETACH DELETE n")
  void deleteGraph();

}
