package org.masouras.model.maria.schema.jpa.control.entity.enums;

import jakarta.persistence.Converter;
import org.masouras.model.maria.schema.jpa.control.entity.enums.base.EnumGenericConverter;

@Converter(autoApply = true)
public class ActivityTypeConverter extends EnumGenericConverter<ActivityType> {
    public ActivityTypeConverter() {
        super(ActivityType.class);
    }
}
