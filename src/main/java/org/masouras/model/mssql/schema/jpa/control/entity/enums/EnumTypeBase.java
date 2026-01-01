package org.masouras.model.mssql.schema.jpa.control.entity.enums;

public interface EnumTypeBase<T extends Enum<T> & EnumTypeBase<T>> {
    String getCode();
}
