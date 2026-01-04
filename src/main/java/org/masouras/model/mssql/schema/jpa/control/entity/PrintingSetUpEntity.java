package org.masouras.model.mssql.schema.jpa.control.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.LetterType;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.LetterTypeConverter;

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
    @Convert(converter = LetterTypeConverter.class)
    @Column(name = "LETTER_TYPE", nullable = false, length = 5)
    private LetterType letterType;


    public PrintingSetUpEntity(PrintingSetUpKey printingSetUpKey, LetterType letterType) {
        this.id = printingSetUpKey;
        this.letterType = letterType;
    }
}

