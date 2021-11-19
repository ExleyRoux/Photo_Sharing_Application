package xyz.ps.controller.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
@ComponentScan("xyz.ps.service")
public class GetUserLogin {
}
