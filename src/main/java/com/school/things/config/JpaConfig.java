package com.school.things.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.school.things.repositories")
@EntityScan(basePackages = "com.school.things.entities")
public class JpaConfig {

}
