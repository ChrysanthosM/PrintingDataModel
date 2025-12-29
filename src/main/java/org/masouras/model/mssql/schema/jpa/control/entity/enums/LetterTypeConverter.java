package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class LetterTypeConverter implements AttributeConverter<LetterType, String> {

    @Override
    public String convertToDatabaseColumn(LetterType attribute) {
        return attribute != null ? attribute.getCode() : null;
    }

    @Override
    public LetterType convertToEntityAttribute(String dbData) {
        return LetterType.getFromCode(dbData);
    }
}
