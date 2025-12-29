package org.masouras.model.mssql.schema.jpa.control.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.LetterType;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.LetterTypeConverter;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LetterSetUpKey implements Serializable {
    @NotNull
    @Convert(converter = LetterTypeConverter.class)
    @Column(name = "LETTER_TYPE", nullable = false, length = 5)
    private LetterType letterType;

    @NotNull
    @Column(name = "SEQ_NO", nullable = false)
    private Integer seqNo;
}
