package org.masouras.model.mssql.schema.jpa.control.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.EnumTypeBase;

@Converter
public abstract class GenericEnumConverter<T extends Enum<T> & EnumTypeBase<T>> implements AttributeConverter<T, String> {
    private final Class<T> enumClass;

    protected GenericEnumConverter(Class<T> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public String convertToDatabaseColumn(T attribute) {
        return attribute != null ? attribute.getCode() : null;
    }

    @Override
    public T convertToEntityAttribute(String dbData) {
        return EnumUtil.fromCode(enumClass, dbData);
    }
}