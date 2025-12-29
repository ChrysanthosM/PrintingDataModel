package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PrintingStatusConverter implements AttributeConverter<PrintingStatus, String> {

    @Override
    public String convertToDatabaseColumn(PrintingStatus attribute) {
        return attribute != null ? attribute.getCode() : null;
    }

    @Override
    public PrintingStatus convertToEntityAttribute(String dbData) {
        return PrintingStatus.getFromCode(dbData);
    }
}
