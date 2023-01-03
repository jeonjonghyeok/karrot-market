package com.numble.karrotmarket.product.domain.constants;

import com.numble.karrotmarket.common.base.LegacyCommonType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductStatus implements LegacyCommonType {

    WAIT("00", "대기"),
    SALE("01", "판매중"),
    RESERVATION("02", "예약중"),
    COMPLETED("03", "거래완료"),
    DELETE("04", "삭제"),
    ;

    private final String legacyType;
    private final String desc;
}
