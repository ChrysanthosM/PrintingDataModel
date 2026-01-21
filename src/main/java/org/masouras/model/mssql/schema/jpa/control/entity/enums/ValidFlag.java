package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.base.EnumTypeBase;
import org.masouras.model.mssql.schema.qb.structure.DbFieldValues;

@RequiredArgsConstructor
@Getter
public enum ValidFlag implements EnumTypeBase<ValidFlag> {
    ENABLED(DbFieldValues.ValuesForValidFlag.ENABLED.getValue()),
    DISABLED(DbFieldValues.ValuesForValidFlag.DISABLED.getValue()),
    ;
    private final String code;
}
