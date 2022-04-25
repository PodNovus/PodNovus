package com.nasutek.podnovus.backend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.nasutek.podnovus.api.*")
public class PodNovusApplication {
        public static void main(String[] args) {
                SpringApplication.run(PodNovusApplication.class, args);
        }

        @Bean
        public GroupedOpenApi v3_OpenAPI() {
                String paths[] = {"/api/v3/**"};
                return GroupedOpenApi.builder().group("PodNovus API v3")
                        .pathsToMatch(paths)
                        .addOpenApiCustomiser(openApi -> {
                                var info = new Info();
                                info.setTitle("PodNovus API");
                                info.setVersion("3.0");
                                info.setDescription("PodNovus v3 API");
                                openApi.setInfo(info);
                        })
                        .build();
        }

        @Bean
        public GroupedOpenApi v2_OpenAPI() {
                String paths[] = {"/api/v2/**"};
                return GroupedOpenApi.builder().group("PodNovus API v2")
                        .pathsToMatch(paths)
                        .addOpenApiCustomiser(openApi -> {
                                var info = new Info();
                                info.setTitle("PodNovus API");
                                info.setVersion("2.0");
                                info.setDescription("PodNovus v2 API is for communicating to Legacy StreamDesk Clients. For PodNovus native features, use the v3 API");
                                openApi.setInfo(info);
                        })
                        .build();
        }
}
