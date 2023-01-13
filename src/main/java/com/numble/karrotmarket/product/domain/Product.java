package com.numble.karrotmarket.product.domain;

import com.numble.karrotmarket.product.domain.constants.ProductStatus;
import com.numble.karrotmarket.product.domain.converter.ProductStatusConverter;
import com.numble.karrotmarket.common.base.BaseTimeEntity;
import com.numble.karrotmarket.product.domain.listener.ProductListener;
import com.numble.karrotmarket.user.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@Table(name = "product", schema = "public")
@SuperBuilder
@EntityListeners(ProductListener.class)
@NoArgsConstructor
public class Product extends BaseTimeEntity {

    @Comment("상품일련번호")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", updatable = false, nullable = false)
    private Long seq;

    @Comment("판매자일련번호")
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User seller;

    @Setter
    private long sellerId;

    @Comment("장소")
    @Column(name = "location", nullable = false)
    private String location;

    @Comment("제목")
    @Column(name = "title", nullable = false)
    private String title;

    @Comment("가격")
    @Column(name = "price", nullable = false)
    private Long price;

    @Comment("본문")
    @Column(name = "content", nullable = false)
    private String content;

    @Comment("상태")
    @Convert(converter = ProductStatusConverter.class)
    @Setter
    @Column(name = "status", nullable = false)
    private ProductStatus status;

    @Comment("카테고리")
    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private Category category;

}
