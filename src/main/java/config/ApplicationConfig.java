package config;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"config","endpoints","entity"})
@EnableJpaRepositories(basePackages = "db")
@EntityScan(basePackages = "entity")
public class ApplicationConfig {
    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(ApplicationConfig.class).run(args);
    }
}
