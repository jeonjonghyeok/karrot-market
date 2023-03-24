package com.numble.karrotmarket.product.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {
    디지털기기,생활가전,
    ;

    public static List<Category> getCategory() {
        return List.of(Category.values());
    }
}
