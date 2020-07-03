package com.study.fcsbadmin.repository;

import com.study.fcsbadmin.model.entity.Item;
import com.study.fcsbadmin.model.entity.User;
import com.study.fcsbadmin.model.enumtype.UserStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    // Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    void create() {
        String account = "Test03";
        String password = "Test03";
        String email = "Test01@gamil.com";
        String phoneNumber = "010-1111-3333";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = User.builder()
                .account(account)
                .password(password)
                .status(UserStatus.REGISTERED)
                .email(email)
                .phoneNumber(phoneNumber)
                .registeredAt(registeredAt)
                .build();

        User newUser = userRepository.save(user);

        assertNotNull(newUser);
    }

    @Test
    @Transactional
    void read() {
        Optional<User> user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        assertNotNull(user);

        user.ifPresent(u -> {
            u.getOrderGroups().forEach(orderGroup -> {

                System.out.println("----- 주문 묶음 -----");
                System.out.println("수령인 : " + orderGroup.getRevName());
                System.out.println("수령지 : " + orderGroup.getRevAddress());
                System.out.println("총금액 : " + orderGroup.getTotalPrice());
                System.out.println("총수량 : " + orderGroup.getTotalQuantity());

                System.out.println("----- 주문 상세 -----");
                orderGroup.getOrderDetails().forEach(orderDetail -> {
                    System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
                    System.out.println("파트너사 카테고리 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
                    System.out.println("주문 상품 : " + orderDetail.getItem().getName());
                    System.out.println("고객센터 번호 : " + orderDetail.getItem().getPartner().getCallCenter());
                    System.out.println("주문의 상태 : " + orderDetail.getStatus());
                    System.out.println("도착예정일자 : " + orderDetail.getArrivalDate());
                });
            });
        });
    }

    @Test
    @Transactional
    void update() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update Method()");

            userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional
    void delete() {
        Optional<User> user = userRepository.findById(3L);

        assertTrue(user.isPresent()); // true 반드시 존재할 경우애만 통과하도록 처리

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(3L);

        assertFalse(deleteUser.isPresent()); // false 반드시 삭제되었는지 확인
    }
}