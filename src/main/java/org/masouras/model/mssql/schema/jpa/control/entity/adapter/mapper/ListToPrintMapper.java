package org.masouras.model.mssql.schema.jpa.control.entity.adapter.mapper;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.masouras.model.mssql.schema.jpa.control.entity.adapter.domain.ListToPrintDTO;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.ActivityType;
import org.masouras.model.mssql.schema.jpa.control.util.EnumUtil;
import org.masouras.model.mssql.schema.qb.structure.DbField;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@UtilityClass
public class ListToPrintMapper {

    public static List<ListToPrintDTO> getListToPrintDTOs(List<Map<String, Object>> rows) {
        return rows.parallelStream()
                .map(row -> new ListToPrintDTO(
                        toLong(row.get(DbField.REC_ID.systemName())),
                        EnumUtil.fromCode(ActivityType.class, Objects.toString(row.get(DbField.ACTIVITY_TYPE.systemName()), StringUtils.EMPTY)),
                        toLong(row.get(DbField.FINAL_CONTENT_ID.systemName()))
                ))
                .toList();
    }
    private static Long toLong(Object value) {
        if (value == null) return null;
        if (value instanceof Number number) return number.longValue();
        return Long.valueOf(value.toString());
    }
}
