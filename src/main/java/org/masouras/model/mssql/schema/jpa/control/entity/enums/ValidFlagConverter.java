package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import jakarta.persistence.Converter;
import org.masouras.model.mssql.schema.jpa.control.util.GenericEnumConverter;

@Converter(autoApply = true)
public class ValidFlagConverter extends GenericEnumConverter<ValidFlag> {
    public ValidFlagConverter() {
        super(ValidFlag.class);
    }
}
