package com.tecchallenge.orderapi.core;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info =
@Info(title = "Order Service API",
        version = "v1",
        description = "Documentation of User Service API")
)
public class OpenApiConfiguration {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .components(new Components())
                .info(
                        new io.swagger.v3.oas.models.info.Info()
                                .title("Order Service API")
                                .version("v1")
                    );
        }
    }


