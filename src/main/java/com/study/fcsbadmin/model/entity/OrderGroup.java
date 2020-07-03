package com.study.fcsbadmin.model.entity;

import com.study.fcsbadmin.model.enumtype.OrderType;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class) // LoginUserAuditorAware 에서 설정한 값이 @CreatedBy @LastModifitedBy 에 값으로 들어가게 된다.
@Table(name = "order_group")
@Builder
@Accessors(chain = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "user", "orderDetails" })
public class OrderGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @Enumerated(EnumType.STRING)
    private OrderType orderType; // 주문의 형태 - 일괄 / 개별

    private String revAddress; // 수신 주소

    private String revName; // 수신인

    private String paymentType; // 결제 방식 - 카드 / 현금

    private BigDecimal totalPrice;

    private Integer totalQuantity; // 전체 수량

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    // OrderGroup N : 1 User
    @ManyToOne
    private User user;

    // OrderGroup 1 : N OrderDetail
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
    private List<OrderDetail> orderDetails;
}
