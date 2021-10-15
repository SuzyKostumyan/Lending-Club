package com.project.app.account;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaRepositories("com.project.app.account.repository")
@ComponentScan(basePackages = {"com.project"})
@EntityScan("com.project.app.account.model")

public class AccountApplication {

    public static void main(String[] args) {
        final SpringApplication application = new SpringApplication(AccountApplication.class);
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.setWebApplicationType(WebApplicationType.SERVLET);
        application.run(args);
    }

     @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
}
