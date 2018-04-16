package ro.ace.ucv.neo4j.config;

import org.neo4j.ogm.config.AutoIndexMode;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories("ro.ace.ucv.neo4j.repository")
public class PersistenceContext {

  @Bean
  public SessionFactory getSessionFactory() {
    return new SessionFactory(configuration(), "ro.ace.ucv.neo4j.model");
  }

  @Bean
  public Session session() {
    return transactionManager().getSessionFactory().openSession();
  }

  @Bean
  public Neo4jTransactionManager transactionManager() {
    return new Neo4jTransactionManager(getSessionFactory());
  }

  @Bean
  public org.neo4j.ogm.config.Configuration configuration() {
    return new org.neo4j.ogm.config.Configuration.Builder()
        .uri("bolt://localhost")
        .credentials("neo4j", "1234")
        .autoIndex(AutoIndexMode.NONE.getName())
        .build();
  }
}