package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.base.EnumTypeBase;
import org.masouras.model.mssql.schema.qb.structure.DbFieldValues;

@RequiredArgsConstructor
@Getter
public enum PrintingStatus implements EnumTypeBase<PrintingStatus> {
    INSERTED(DbFieldValues.ValuesForPrintingStatus.INSERTED.getValue()),
    VALIDATED(DbFieldValues.ValuesForPrintingStatus.VALIDATED.getValue()),
    PROCESSED(DbFieldValues.ValuesForPrintingStatus.PROCESSED.getValue()),
    PRINTED(DbFieldValues.ValuesForPrintingStatus.PRINTED.getValue()),
    DUMMY(DbFieldValues.ValuesForPrintingStatus.DUMMY.getValue()),
    ERROR(DbFieldValues.ValuesForPrintingStatus.ERROR.getValue()),
    ;
    private final String code;
}
