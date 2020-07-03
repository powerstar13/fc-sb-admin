package com.study.fcsbadmin.repository;

import com.study.fcsbadmin.model.entity.AdminUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminUserRepositoryTest {
    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    void create() {
        AdminUser adminUser = AdminUser.builder()
                .account("AdminUser02")
                .password("AdminUser02")
                .status("REGISTERED")
                .role("PARTNER")
                .build();

        AdminUser newAdminUser = adminUserRepository.save(adminUser);

        assertNotNull(newAdminUser);

        newAdminUser.setAccount("CHANGE");
        adminUserRepository.save(newAdminUser);
    }
}