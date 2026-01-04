package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.base.EnumTypeBase;
import org.masouras.model.mssql.schema.qb.structure.DbFieldValues;

@RequiredArgsConstructor
@Getter
public enum ActivityType implements EnumTypeBase<ActivityType> {
    POLICY_NEW(DbFieldValues.ValuesForActivityType.POLICY_NEW.getValue()),
    ;
    private final String code;
}
