package xyz.ps.service.config;

import org.springframework.context.annotation.*;
import xyz.ps.repository.config.RepositoryConfig;

@Configuration
@Import({RepositoryConfig.class})
@ComponentScan(basePackages = {
        "xyz.ps.service"
})
public class ServiceConfig {
}
