package com.numble.karrotmarket.product.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "product", schema = "public")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", updatable = false, nullable = false)
    private Long seq;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

}
