package org.masouras.model.mssql.schema.jpa.control.vaadin;

import com.vaadin.flow.component.Component;
import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FormField {
    Class<? extends Component> component();
    int order() default 0;
    int colspan() default 1;
    String group() default StringUtils.EMPTY;
    String label() default StringUtils.EMPTY;
    boolean required() default false;
    boolean key() default false;
}
