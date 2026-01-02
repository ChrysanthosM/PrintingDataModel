package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.base.EnumTypeBase;

@RequiredArgsConstructor
@Getter
public enum FileExtensionType implements EnumTypeBase<FileExtensionType> {
    XML("001"),
    ;

    private final String code;
}
