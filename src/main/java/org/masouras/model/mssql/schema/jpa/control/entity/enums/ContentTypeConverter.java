package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import jakarta.persistence.Converter;
import org.masouras.model.mssql.schema.jpa.control.util.GenericEnumConverter;

@Converter(autoApply = true)
public class ContentTypeConverter extends GenericEnumConverter<ContentType> {
    public ContentTypeConverter() {
        super(ContentType.class);
    }
}
