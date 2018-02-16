package com.iquestgroup.neo4jdemo.config;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.iquestgroup.neo4jdemo.repository")
@EnableTransactionManagement
public class CustomNeo4jConfiguration extends Neo4jConfiguration {

  @Override
  @Bean
  public SessionFactory getSessionFactory() {
    // with domain entity base package(s)
    return new SessionFactory("com.iquestgroup.neo4jdemo.model");
  }

  // needed for session in view in web-applications
  @Override
  @Bean
  @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
  public Session getSession() throws Exception {
    return super.getSession();
  }

}
