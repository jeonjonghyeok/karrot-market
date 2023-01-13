package com.numble.karrotmarket.product.domain.converter;

import com.numble.karrotmarket.common.utils.LegacyEnumValueConvertUtils;
import com.numble.karrotmarket.product.domain.constants.ProductStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ProductStatusConverter implements AttributeConverter<ProductStatus, String> {

    @Override
    public String convertToDatabaseColumn(ProductStatus attribute) {
        return LegacyEnumValueConvertUtils.toLegacyCode(attribute);
    }

    @Override
    public ProductStatus convertToEntityAttribute(String dbData) {
        return LegacyEnumValueConvertUtils.ofLegacyCode(ProductStatus.class, dbData);
    }
}
