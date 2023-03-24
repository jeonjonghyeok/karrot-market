package com.numble.karrotmarket.chat.domain;

import com.numble.karrotmarket.common.base.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@Table(name = "chat_room", schema = "public")
@SuperBuilder
@NoArgsConstructor
public class ChatRoom extends BaseTimeEntity {

    @Comment("채팅방일련번호")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", updatable = false, nullable = false)
    private Long seq;

    @Column(name = "product_id", updatable = false, nullable = false)
    private Long productId;

    @Column(name = "title")
    private String title;

}
