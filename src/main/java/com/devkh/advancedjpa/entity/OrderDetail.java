package com.devkh.advancedjpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Order order;

    private Integer qty;
    private String remark;
}
