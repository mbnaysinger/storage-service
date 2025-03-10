package br.org.naysinger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI(ApplicationContext applicationContext) {
        String contextPath = applicationContext.getEnvironment().getProperty("server.servlet.context-path", "/");
        Server server = new Server().url(contextPath);

        return new OpenAPI()
                .info(new Info().title("Storage Service")
                        .description(
                                "Reactive API of Storage Service")
                        .version("v1.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .servers(List.of(server));
    }
}
