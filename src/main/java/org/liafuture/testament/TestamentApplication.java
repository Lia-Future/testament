package org.liafuture.testament;

import org.liafuture.testament.repository.RoleRepository;
import org.liafuture.testament.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {
        UserRepository.class,
        RoleRepository.class
})
public class TestamentApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestamentApplication.class, args);
    }

}
