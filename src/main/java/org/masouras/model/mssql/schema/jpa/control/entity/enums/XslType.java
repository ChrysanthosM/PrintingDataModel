package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.base.EnumTypeBase;
import org.masouras.model.mssql.schema.qb.structure.DbFieldValues;


@RequiredArgsConstructor
@Getter
public enum XslType implements EnumTypeBase<XslType> {
    POLICY_XSL(DbFieldValues.ValuesForXslType.POLICY_XSL.getValue()),
    ;
    private final String code;
}
