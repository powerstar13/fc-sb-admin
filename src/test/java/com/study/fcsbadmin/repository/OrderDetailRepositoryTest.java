package com.study.fcsbadmin.repository;

import com.study.fcsbadmin.model.entity.Item;
import com.study.fcsbadmin.model.entity.OrderDetail;
import com.study.fcsbadmin.model.entity.OrderGroup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    void create() {
        OrderDetail orderDetail = OrderDetail.builder()
                .status("WAITING")
                .arrivalDate(LocalDateTime.now().plusDays(2))
                .quantity(1)
                .totalPrice(BigDecimal.valueOf(9000000))
                .createdAt(LocalDateTime.now())
                .createdBy("AdminServer")
                .orderGroup(OrderGroup.builder().id(1L).build()) // 어떠한 장바구니에
                .item(Item.builder().id(1L).build()) // 어떠한 상품
                .build();

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);

        assertNotNull(newOrderDetail);
    }
}