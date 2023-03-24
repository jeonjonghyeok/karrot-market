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
@Table(name = "chat", schema = "public")
@SuperBuilder
@NoArgsConstructor
public class Chat extends BaseTimeEntity {

    @Comment("채팅일련번호")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", updatable = false, nullable = false)
    private Long seq;

    @Column(name = "room_id", updatable = false, nullable = false)
    private Long roomId;

    @Column(name = "user_id", updatable = false, nullable = false)
    private Long userId;

    @Column(name = "message", updatable = false, nullable = false)
    private String message;

}
