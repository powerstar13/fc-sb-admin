package com.study.fcsbadmin.repository;

import com.study.fcsbadmin.model.entity.Item;
import com.study.fcsbadmin.model.entity.Partner;
import com.study.fcsbadmin.model.enumtype.ItemStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    void create() {
        Item item = Item.builder()
                .status(ItemStatus.UNREGISTERED)
                .name("삼성 노트북")
                .title("삼성 노트북 A100")
                .content("2019년형 노트북 입니다")
                .price(BigDecimal.valueOf(900000))
                .brandName("삼성")
                .registeredAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .createdBy("Partner01")
                .partner(Partner.builder().id(1L).build())
                .build();

        Item newItem = itemRepository.save(item);

        assertNotNull(newItem);
    }

    @Test
    void read() {
        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);

        assertTrue(item.isPresent());
    }
}