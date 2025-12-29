package org.masouras.model.mssql.schema.jpa.control.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.*;

@Entity
@Table(name = "LetterSetUpTable")
@Data
@NoArgsConstructor
public class LetterSetUpEntity {
    @EmbeddedId
    @Valid
    @NotNull
    private LetterSetUpKey id;

    @NotNull
    @Convert(converter = XslTypeConverter.class)
    @Column(name = "XSL_TYPE", nullable = false, length = 50)
    private XslType xslType;

    @NotNull
    @Convert(converter = RenderTypeConverter.class)
    @Column(name = "RENDER_TYPE", nullable = false, length = 3)
    private RendererType renderType;

    @NotNull
    @Convert(converter = ValidFlagConverter.class)
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
    private ValidFlag validFlag;
}

