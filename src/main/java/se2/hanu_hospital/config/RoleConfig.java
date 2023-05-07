package se2.hanu_hospital.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se2.hanu_hospital.account.model.Role;
import se2.hanu_hospital.account.model.RoleName;
import se2.hanu_hospital.account.RoleRepository;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RoleConfig {
    @Bean
    CommandLineRunner orderLineCommandLineRunner(RoleRepository roleRepository) {
        return args -> {
            Role role = roleRepository.findByName(RoleName.ROLE_ADMIN);
            if (role == null) {
                Role r1 = new Role();
                r1.setName(RoleName.ROLE_ADMIN);
                Role r2 = new Role();
                r2.setName(RoleName.ROLE_NURSE);
                Role r3 = new Role();
                r3.setName(RoleName.ROLE_DOCTOR);
                List<Role> list = new ArrayList<>();
                list.add(r1);
                list.add(r2);
                list.add(r3);

                roleRepository.saveAll(list);
            }
        };
    }
}