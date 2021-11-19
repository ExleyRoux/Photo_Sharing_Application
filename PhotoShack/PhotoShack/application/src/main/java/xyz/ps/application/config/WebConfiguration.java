package xyz.ps.application.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import xyz.ps.controller.config.ControllerConfig;

@Import({ControllerConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "xyz.ps.application",
        "xyz.ps.controller"
})
public class WebConfiguration {
}
