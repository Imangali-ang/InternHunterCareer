package org.ihc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

@SpringBootApplication
public class InternHunterCareerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternHunterCareerApplication.class, args);
    }
}
