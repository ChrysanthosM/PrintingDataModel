package org.masouras.model.mssql.schema.jpa.control.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum FileExtensionType implements EnumTypeBase<FileExtensionType> {
    XML("001"),
    ;

    private final String code;
}
