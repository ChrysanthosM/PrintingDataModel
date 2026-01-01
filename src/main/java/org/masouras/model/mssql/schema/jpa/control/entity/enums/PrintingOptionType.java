package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.qb.structure.DbFieldValues;

@RequiredArgsConstructor
@Getter
public enum PrintingOptionType implements EnumTypeBase<PrintingOptionType> {
    SYS_PARAM(DbFieldValues.ValuesForOptionType.SYS_PARAM.getValue()),
    FORM_SETTING(DbFieldValues.ValuesForOptionType.FORM_SETTING.getValue()),
    ;
    private final String code;
}
