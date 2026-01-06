package org.masouras.model.mssql.schema.jpa.control.entity;

import com.vaadin.flow.component.combobox.ComboBox;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.LetterType;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.LetterTypeConverter;
import org.masouras.model.mssql.schema.jpa.control.vaadin.FormField;

@Entity
@Table(name = "PrintingSetUpTable")
@Data
@NoArgsConstructor
public class PrintingSetUpEntity {
    @EmbeddedId
    @Valid
    @NotNull
    private PrintingSetUpKey id;

    @NotNull
    @FormField(component = ComboBox.class, label = "Letter Type", required = true, order = 1)
    @Convert(converter = LetterTypeConverter.class)
    @Column(name = "LETTER_TYPE", nullable = false, length = 5)
    private LetterType letterType;


    public PrintingSetUpEntity(PrintingSetUpKey printingSetUpKey, LetterType letterType) {
        this.id = printingSetUpKey;
        this.letterType = letterType;
    }
}

