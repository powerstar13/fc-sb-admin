package com.study.fcsbadmin.repository;

import com.study.fcsbadmin.model.entity.Category;
import com.study.fcsbadmin.model.entity.Partner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PartnerRepositoryTest {
    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    void create() {
        String name = "Partner01";
        String status = "REGISTERED";
        String addrss = "서울시 강남구";
        String callCenter = "070-1111-2222";
        String partnerNumber = "010-1111-2222";
        String businessNumber = "1234567890123";
        String ceoName = "홍길동";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";
        Long categoryId = 1L;

        Partner partner = Partner.builder()
                .name(name)
                .status(status)
                .address(addrss)
                .callCenter(callCenter)
                .partnerNumber(partnerNumber)
                .businessNumber(businessNumber)
                .ceoName(ceoName)
                .registeredAt(registeredAt)
                .createdAt(createdAt)
                .createdBy(createdBy)
                .category(Category.builder().id(categoryId).build())
                .build();

        Partner newPartner = partnerRepository.save(partner);

        assertNotNull(newPartner);
        assertEquals(newPartner.getName(), name);
    }
}