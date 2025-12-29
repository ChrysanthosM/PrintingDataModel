package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class FileExtensionTypeConverter implements AttributeConverter<FileExtensionType, String> {

    @Override
    public String convertToDatabaseColumn(FileExtensionType attribute) {
        return attribute != null ? attribute.getCode() : null;
    }

    @Override
    public FileExtensionType convertToEntityAttribute(String dbData) {
        return FileExtensionType.getFromCode(dbData);
    }
}
