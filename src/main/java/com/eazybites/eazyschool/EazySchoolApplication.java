package com.eazybites.eazyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableAspectJAutoProxy
@EntityScan("com.eazybites.eazyschool.model")
@EnableJpaRepositories("com.eazybites.eazyschool.repository")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class EazySchoolApplication{
    public static void main(String[] args) {
        SpringApplication.run(EazySchoolApplication.class, args);
    }
}
