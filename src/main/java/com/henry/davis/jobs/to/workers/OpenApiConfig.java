package com.henry.davis.jobs.to.workers;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class OpenApiConfig {

    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Find your top 3 jobs")
                        .description("An API to match a worker with his best possible selection of jobs")
                        .version("1.0"));
    }
}
