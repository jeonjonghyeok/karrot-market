package com.numble.karrotmarket.product.domain.listener;

import com.numble.karrotmarket.product.domain.constants.ProductStatus;
import com.numble.karrotmarket.common.utils.BeanUtils;
import com.numble.karrotmarket.product.domain.Product;
import com.numble.karrotmarket.user.domain.User;
import com.numble.karrotmarket.user.repository.UserRepository;
import jakarta.persistence.PrePersist;
import org.springframework.stereotype.Component;

@Component
public class ProductListener {

    @PrePersist
    public void prePersist(final Product product) {
        UserRepository userRepository = (UserRepository) BeanUtils.getBean(UserRepository.class);
        User user = userRepository.findById(product.getSellerId()).orElseThrow();
        product.setSeller(user);
        product.setStatus(ProductStatus.WAIT);
    }

}
