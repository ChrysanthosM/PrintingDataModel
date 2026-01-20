package org.masouras.model.mssql.schema.jpa.control.entity.adapter.mapper;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.masouras.model.mssql.schema.jpa.control.entity.adapter.projection.PrintingLetterSetUpProjectionImplementor;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.*;
import org.masouras.model.mssql.schema.jpa.control.util.EnumUtil;
import org.masouras.model.mssql.schema.qb.structure.DbField;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@UtilityClass
public class PrintingLetterSetUpMapper {
    public static @NonNull List<PrintingLetterSetUpProjectionImplementor> getPrintingLetterSetUpProjectionImplementors(List<Map<String, Object>> rows) {
        return rows.stream()
                .map(row -> new PrintingLetterSetUpProjectionImplementor(
                        EnumUtil.fromCode(ActivityType.class, Objects.toString(row.get(DbField.ACTIVITY_TYPE.systemName()))),
                        EnumUtil.fromCode(ContentType.class, Objects.toString(row.get(DbField.CONTENT_TYPE.systemName()))),
                        EnumUtil.fromCode(LetterType.class, Objects.toString(row.get(DbField.LETTER_TYPE.systemName()))),
                        EnumUtil.fromCode(XslType.class, Objects.toString(row.get(DbField.XSL_TYPE.systemName()))),
                        EnumUtil.fromCode(RendererType.class, Objects.toString(row.get(DbField.RENDERER_TYPE.systemName()))),
                        EnumUtil.fromCode(ValidFlag.class, Objects.toString(row.get(DbField.VALID_FLAG.systemName())))
                ))
                .toList();
    }
}
