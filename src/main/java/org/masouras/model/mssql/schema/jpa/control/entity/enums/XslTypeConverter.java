package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class XslTypeConverter implements AttributeConverter<XslType, String> {

    @Override
    public String convertToDatabaseColumn(XslType attribute) {
        return attribute != null ? attribute.getCode() : null;
    }

    @Override
    public XslType convertToEntityAttribute(String dbData) {
        return XslType.getFromCode(dbData);
    }
}
