package com.study.fcsbadmin.repository;

import com.study.fcsbadmin.model.entity.Category;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void create() {
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = Category.builder()
                .type(type)
                .title(title)
                .createdAt(createdAt)
                .createdBy(createdBy)
                .build();

        Category newCategory = categoryRepository.save(category);

        assertNotNull(newCategory);
        assertEquals(newCategory.getType(), type);
        assertEquals(newCategory.getTitle(), title);
    }

    @Test
    void read() {
        String type = "COMPUTER";

        Optional<Category> category = categoryRepository.findByType(type);

        category.ifPresent(c -> {
            assertEquals(c.getType(), type);

            System.out.println(c);
        });
    }
}