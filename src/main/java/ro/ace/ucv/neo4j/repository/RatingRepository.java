package ro.ace.ucv.neo4j.repository;

import ro.ace.ucv.neo4j.model.Rating;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends Neo4jRepository<Rating, Long> {


}
