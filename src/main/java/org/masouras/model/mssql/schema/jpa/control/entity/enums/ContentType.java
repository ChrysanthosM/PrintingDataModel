package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.base.EnumTypeBase;
import org.masouras.model.mssql.schema.qb.structure.DbFieldValues;

@RequiredArgsConstructor
@Getter
public enum ContentType implements EnumTypeBase<ContentType> {
    XML_POLICY(DbFieldValues.ValuesForContentType.XML_POLICY.getValue()),
    XML_BILLING(DbFieldValues.ValuesForContentType.XML_BILLING.getValue()),
    ;
    private final String code;
}
