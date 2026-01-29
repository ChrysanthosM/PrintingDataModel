package org.masouras.model.mssql.schema.jpa.control.entity.adapter.mapper;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.masouras.model.mssql.schema.jpa.control.entity.adapter.domain.ListToPrintDTO;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@UtilityClass
public class ListToPrintMapper {

    public List<ListToPrintDTO> getListToPrintDTOs(List<Map<String,Object>> rows) {
        return rows.parallelStream()
                .map(row -> new ListToPrintDTO(
                        toLong(row.get("REC_ID")),
                        toLong(row.get("FINAL_CONTENT_ID")),
                        Objects.toString(row.get("ACTIVITY_TYPE"), StringUtils.EMPTY)
                ))
                .toList();
    }

    private Long toLong(Object value) {
        if (value == null) return null;
        if (value instanceof Number number) return number.longValue();
        return Long.valueOf(value.toString());
    }
}
