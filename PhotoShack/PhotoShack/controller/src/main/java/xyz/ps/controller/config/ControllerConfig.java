package xyz.ps.controller.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import xyz.ps.service.config.ServiceConfig;

@Import({ServiceConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "xyz.ps.controller.api",
        "xyz.ps.controller.request"
})
public class ControllerConfig {
}
