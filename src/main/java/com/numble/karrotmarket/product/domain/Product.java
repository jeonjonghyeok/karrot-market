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
    @Column(name = "seq", nullable = false)
    private Long seq;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

}
