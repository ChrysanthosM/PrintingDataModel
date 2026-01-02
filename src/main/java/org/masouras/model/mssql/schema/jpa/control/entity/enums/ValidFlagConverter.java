package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import jakarta.persistence.Converter;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.base.EnumGenericConverter;

@Converter(autoApply = true)
public class ValidFlagConverter extends EnumGenericConverter<ValidFlag> {
    public ValidFlagConverter() {
        super(ValidFlag.class);
    }
}
