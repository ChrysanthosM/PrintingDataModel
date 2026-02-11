package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.base.EnumTypeBase;
import org.masouras.model.mssql.schema.qb.structure.DbFieldValues;

@RequiredArgsConstructor
@Getter
public enum RendererType implements EnumTypeBase<RendererType> {
    FOP(DbFieldValues.ValuesForRendererType.FOP.getValue()),
    FLYING_SAUCER(DbFieldValues.ValuesForRendererType.FLYING_SAUCER.getValue()),
    ;
    private final String code;
}
