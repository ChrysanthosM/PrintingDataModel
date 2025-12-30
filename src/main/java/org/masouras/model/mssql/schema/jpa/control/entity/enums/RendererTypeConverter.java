package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RendererTypeConverter implements AttributeConverter<RendererType, String> {

    @Override
    public String convertToDatabaseColumn(RendererType attribute) {
        return attribute != null ? attribute.getCode() : null;
    }

    @Override
    public RendererType convertToEntityAttribute(String dbData) {
        return RendererType.getFromCode(dbData);
    }
}
