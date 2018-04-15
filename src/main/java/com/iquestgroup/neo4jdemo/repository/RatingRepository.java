package com.iquestgroup.neo4jdemo.repository;

import com.iquestgroup.neo4jdemo.model.Rating;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends Neo4jRepository<Rating, Long> {


}
