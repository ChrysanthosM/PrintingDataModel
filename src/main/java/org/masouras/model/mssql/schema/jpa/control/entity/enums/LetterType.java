package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.base.EnumTypeBase;
import org.masouras.model.mssql.schema.qb.structure.DbFieldValues;

@RequiredArgsConstructor
@Getter
public enum LetterType implements EnumTypeBase<LetterType> {
    POLICY(DbFieldValues.ValuesForLetterType.POLICY.getValue()),
    ;
    private final String code;
}
