package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.qb.structure.DbFieldValues;

@RequiredArgsConstructor
@Getter
public enum ActivityType implements EnumTypeBase<ActivityType> {
    QUOTATION_NEW(DbFieldValues.ValuesForActivityType.QUOTATION_NEW.getValue()),
    ;
    private final String code;
}
