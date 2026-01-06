package org.masouras.model.mssql.schema.jpa.control.entity;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.textfield.IntegerField;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.ActivityType;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.ActivityTypeConverter;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.ContentType;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.ContentTypeConverter;
import org.masouras.model.mssql.schema.jpa.control.vaadin.FormField;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrintingSetUpKey implements Serializable {
    @NotNull
    @FormField(component = ComboBox.class, label = "Activity Type", required = true, key = true)
    @Convert(converter = ActivityTypeConverter.class)
    @Column(name = "ACTIVITY_TYPE", nullable = false, length = 5)
    private ActivityType activityType;

    @NotNull
    @FormField(component = ComboBox.class, label = "Content Type", required = true, key = true)
    @Convert(converter = ContentTypeConverter.class)
    @Column(name = "CONTENT_TYPE", nullable = false, length = 5)
    private ContentType contentType;

    @NotNull
    @FormField(component = IntegerField.class, label = "Sequence No", required = true, key = true)
    @Column(name = "SEQ_NO")
    private Integer seqNo;
}
