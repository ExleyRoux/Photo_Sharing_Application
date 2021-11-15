package xyz.ps.model.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {
        "xyz.ps.model.dto",
        "xyz.ps.model.mapper"
})
public class ModelConfig {
}
