package com.numble.karrotmarket.product.domain.mapper;

import com.numble.karrotmarket.common.base.BaseMapping;
import com.numble.karrotmarket.product.controller.dto.ProductCreationRequest;
import com.numble.karrotmarket.product.controller.dto.ProductResponse;
import com.numble.karrotmarket.product.domain.Product;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductDtoMapper {

    @BaseMapping
    @Mapping(target = "seq", ignore = true)
    @Mapping(target = "status", ignore = true)
    Product toProduct(ProductCreationRequest source);

    @Named("toProductResponse")
    ProductResponse toProductResponse(Product source);

    @IterableMapping(qualifiedByName = "toProductResponse")
    List<ProductResponse> toProductResponses(List<Product> source);

}
