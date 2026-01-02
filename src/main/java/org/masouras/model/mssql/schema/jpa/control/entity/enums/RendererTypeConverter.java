package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import jakarta.persistence.Converter;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.base.EnumGenericConverter;

@Converter(autoApply = true)
public class RendererTypeConverter extends EnumGenericConverter<RendererType> {
    public RendererTypeConverter() {
        super(RendererType.class);
    }
}
