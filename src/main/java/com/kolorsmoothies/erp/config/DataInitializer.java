package com.kolorsmoothies.erp.config;

import com.kolorsmoothies.erp.enums.Role;
import com.kolorsmoothies.erp.enums.UserStatus;
import com.kolorsmoothies.erp.user.entity.User;
import com.kolorsmoothies.erp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        if (userRepository.existsByEmail("admin@kolorsmoothies.com")) {
            return;
        }

        User admin = User.builder()
                .firstName("System")
                .lastName("Administrator")
                .email("admin@kolorsmoothies.com")
                .phone("9999999999")
                .password(passwordEncoder.encode("Admin@123"))
                .role(Role.ADMIN)
                .status(UserStatus.ACTIVE)
                .build();

        userRepository.save(admin);

        System.out.println("==================================");
        System.out.println("Default Admin Created");
        System.out.println("Email : admin@kolorsmoothies.com");
        System.out.println("Password : Admin@123");
        System.out.println("==================================");
    }
}