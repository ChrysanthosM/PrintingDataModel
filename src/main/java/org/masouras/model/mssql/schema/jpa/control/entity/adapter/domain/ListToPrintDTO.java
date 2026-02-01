package org.masouras.model.mssql.schema.jpa.control.entity.adapter.domain;

import com.vaadin.flow.component.textfield.TextField;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.ActivityType;
import org.masouras.model.mssql.schema.jpa.control.vaadin.FormField;

@Data
@AllArgsConstructor
public class ListToPrintDTO {
    private Long recId;

    @FormField(component = TextField.class, order = 1, label = "Activity Type")
    private ActivityType activityType;

    @FormField(component = TextField.class, order = 2, label = "Final Content ID")
    private Long finalContentId;
}
