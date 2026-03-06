package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.base.EnumTypeBase;
import org.masouras.model.mssql.schema.qb.structure.DbFieldValues;

@RequiredArgsConstructor
@Getter
public enum PrintingWayType implements EnumTypeBase<PrintingWayType> {
    BATCH(DbFieldValues.ValuesForPrintingWayType.BATCH.getValue()),
    RABBIT(DbFieldValues.ValuesForPrintingWayType.RABBIT.getValue()),
    ;
    private final String code;
}
