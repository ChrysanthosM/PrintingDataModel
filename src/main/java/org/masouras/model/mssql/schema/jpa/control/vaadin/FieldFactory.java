package org.masouras.model.mssql.schema.jpa.control.vaadin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasLabel;
import com.vaadin.flow.component.HasPlaceholder;
import com.vaadin.flow.component.combobox.ComboBox;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;

@UtilityClass
public class FieldFactory {

    @SuppressWarnings("unchecked")
    public static Component createField(Field field, FormField formField) {
        try {
            Component component = formField.component().getDeclaredConstructor().newInstance();

            if (component instanceof HasLabel label) {
                label.setLabel(formField.label());
            }
            if (component instanceof HasPlaceholder placeholder) {
                placeholder.setPlaceholder(formField.label());
            }

            if (component instanceof ComboBox<?> combo) {
                Class<?> enumType = field.getType();
                if (enumType.isEnum()) {
                    ComboBox<Object> cb = (ComboBox<Object>) combo;
                    cb.setItems(enumType.getEnumConstants());
                }
            }

            return component;
        } catch (Exception e) {
            throw new RuntimeException("Cannot create field for " + field.getName(), e);
        }
    }
}
