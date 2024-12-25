package com.kubemachine.engine.api.generic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

@Configuration
public class Config implements RepositoryRestConfigurer {

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer(EntityManager entityManager) {
        return RepositoryRestConfigurer.withConfig(config -> {
            config.exposeIdsFor(entityManager.getMetamodel().getEntities()
                    .stream().map(Type::getJavaType).toArray(Class[]::new));
        });
    }
}