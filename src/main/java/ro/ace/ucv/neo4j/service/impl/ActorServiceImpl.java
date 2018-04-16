package ro.ace.ucv.neo4j.service.impl;

import ro.ace.ucv.neo4j.repository.ActorRepository;
import ro.ace.ucv.neo4j.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl implements ActorService {

  @Autowired
  private ActorRepository actorRepository;

}
