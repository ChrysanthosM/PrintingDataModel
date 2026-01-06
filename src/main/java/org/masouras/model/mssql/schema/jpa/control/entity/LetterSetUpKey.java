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
import org.masouras.model.mssql.schema.jpa.control.entity.enums.LetterType;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.LetterTypeConverter;
import org.masouras.model.mssql.schema.jpa.control.vaadin.FormField;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LetterSetUpKey implements Serializable {
    @NotNull
    @FormField(component = ComboBox.class, label = "Letter Type", required = true, key = true)
    @Convert(converter = LetterTypeConverter.class)
    @Column(name = "LETTER_TYPE", nullable = false, length = 5)
    private LetterType letterType;

    @NotNull
    @FormField(component = IntegerField.class, label = "Sequence No", required = true, key = true)
    @Column(name = "SEQ_NO", nullable = false)
    private Integer seqNo;
}
