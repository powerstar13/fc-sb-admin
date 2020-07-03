package com.study.fcsbadmin.repository;

import com.study.fcsbadmin.model.entity.OrderGroup;
import com.study.fcsbadmin.model.entity.User;
import com.study.fcsbadmin.model.enumtype.OrderType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderGroupRepositoryTest {
    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Test
    void create() {
        OrderGroup orderGroup = OrderGroup.builder()
                .status("COMPLETE")
                .orderType(OrderType.ALL)
                .revAddress("서울시 강남구")
                .revName("홍길동")
                .paymentType("CARD")
                .totalPrice(BigDecimal.valueOf(900000))
                .totalQuantity(1)
                .orderAt(LocalDateTime.now().minusDays(2))
                .arrivalDate(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .createdBy("AdminServer")
                .user(User.builder().id(1L).build())
                .build();

        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);

        assertNotNull(newOrderGroup);
    }
}