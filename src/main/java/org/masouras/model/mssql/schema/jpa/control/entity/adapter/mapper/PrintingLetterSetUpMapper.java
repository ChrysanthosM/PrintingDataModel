package org.masouras.model.mssql.schema.jpa.control.entity.adapter.mapper;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.masouras.model.mssql.schema.jpa.control.entity.adapter.projection.PrintingLetterSetUpProjectionImplementor;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.*;
import org.masouras.model.mssql.schema.jpa.control.util.EnumUtil;
import org.masouras.model.mssql.schema.qb.structure.DbField;

import java.util.List;
import java.util.Map;

@UtilityClass
public class PrintingLetterSetUpMapper {
    public static @NonNull List<PrintingLetterSetUpProjectionImplementor> getPrintingLetterSetUpProjectionImplementors(List<Map<String, Object>> rows) {
        return rows.stream()
                .map(row -> new PrintingLetterSetUpProjectionImplementor(
                        EnumUtil.fromCode(ActivityType.class, (String) row.get(DbField.ACTIVITY_TYPE.systemName())),
                        EnumUtil.fromCode(ContentType.class, (String) row.get(DbField.CONTENT_TYPE.systemName())),
                        EnumUtil.fromCode(LetterType.class, (String) row.get(DbField.LETTER_TYPE.systemName())),
                        EnumUtil.fromCode(XslType.class, (String) row.get(DbField.XSL_TYPE.systemName())),
                        EnumUtil.fromCode(RendererType.class, (String) row.get(DbField.RENDERER_TYPE.systemName())),
                        EnumUtil.fromCode(ValidFlag.class, (String) row.get(DbField.VALID_FLAG.systemName()))
                ))
                .toList();
    }
}
