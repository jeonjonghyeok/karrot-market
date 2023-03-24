package com.numble.karrotmarket.product.domain.listener;

import com.numble.karrotmarket.product.domain.Product;
import com.numble.karrotmarket.product.domain.constants.ProductStatus;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductListener {

    @PrePersist
    public void prePersist(final Product product) {
        product.setStatus(ProductStatus.WAIT);
    }

    @PreUpdate
    public void preUpdate(final Product product) {
        log.info("pre Update call");
    }

}
