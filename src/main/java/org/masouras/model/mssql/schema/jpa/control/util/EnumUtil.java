package org.masouras.model.mssql.schema.jpa.control.util;

import jakarta.annotation.Nullable;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.base.EnumTypeBase;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@UtilityClass
public class EnumUtil {
    private static final Map<Class<?>, Map<String, ?>> CACHE_ENUM_CODES = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    public static <T extends Enum<T> & EnumTypeBase<T>> T fromCode(Class<T> enumClass, @Nullable String code) {
        Map<String, T> map = (Map<String, T>) CACHE_ENUM_CODES.computeIfAbsent(enumClass, _ ->
                Arrays.stream(enumClass.getEnumConstants())
                        .collect(Collectors.toMap(
                                e -> e.getCode().trim(),
                                e -> e
                        ))
        );
        return map.get(StringUtils.trimToEmpty(code));
    }
}
