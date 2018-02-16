package com.iquestgroup.neo4jdemo.repository;

import com.iquestgroup.neo4jdemo.model.Rating;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends GraphRepository<Rating> {


}
