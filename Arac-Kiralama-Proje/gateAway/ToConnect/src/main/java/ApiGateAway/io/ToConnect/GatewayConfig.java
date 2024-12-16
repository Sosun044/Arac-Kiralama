package ApiGateAway.io.ToConnect;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("service1-route", r -> r
                        .path("/user/**")
                        .uri("http://localhost:8081"))
                // Dördüncü Rota: Service2 yönlendirme
                .route("service2-route", r -> r
                        .path("/service2/**")
                        .uri("http://localhost:8082"))
                .build();

    }
}