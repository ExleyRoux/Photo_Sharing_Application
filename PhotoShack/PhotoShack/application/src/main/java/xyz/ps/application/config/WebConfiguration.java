package xyz.ps.application.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "xyz.ps.application.controller"
})
public class WebConfiguration {
}
