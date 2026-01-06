package org.masouras.model.mssql.schema.jpa.control.util;

import lombok.experimental.UtilityClass;
import org.hibernate.query.TupleTransformer;
import org.masouras.model.mssql.schema.jpa.control.vaadin.FormField;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@UtilityClass
public class RepositoryUtils {
    public static TupleTransformer<Map<String, Object>> tupleTransformer() {
        return (tuple, aliases) ->
                IntStream.range(0, aliases.length)
                        .boxed()
                        .collect(Collectors.toMap(
                                i -> aliases[i],
                                i -> tuple[i]
                        ));
    }

    public static List<Field> getKeyFields(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(FormField.class))
                .filter(f -> f.getAnnotation(FormField.class).key())
                .toList();
    }

}
