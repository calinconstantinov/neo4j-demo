package ro.ace.ucv.neo4j.config;

import com.google.common.collect.Maps;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class ConstraintCreator {

  @Autowired
  private Session session;

  @PostConstruct
  public void postConstruct() {
    createConstraints();
  }

  @Transactional
  public void createConstraints() {
    session.query("CREATE CONSTRAINT ON (m:Movie) ASSERT m.title IS UNIQUE", Maps.newHashMap());
  }

}
