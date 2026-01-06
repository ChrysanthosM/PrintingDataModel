package org.masouras.model.mssql.schema.jpa.control.entity;

import com.vaadin.flow.component.combobox.ComboBox;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.*;
import org.masouras.model.mssql.schema.jpa.control.vaadin.FormField;

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
    @FormField(component = ComboBox.class, label = "XSL Type", required = true, order = 1)
    @Convert(converter = XslTypeConverter.class)
    @Column(name = "XSL_TYPE", nullable = false, length = 50)
    private XslType xslType;

    @NotNull
    @FormField(component = ComboBox.class, label = "Renderer Type", required = true, order = 2)
    @Convert(converter = RendererTypeConverter.class)
    @Column(name = "RENDERER_TYPE", nullable = false, length = 3)
    private RendererType rendererType;

    @NotNull
    @FormField(component = ComboBox.class, label = "Valid Flag", required = true, order = 3)
    @Convert(converter = ValidFlagConverter.class)
    @Column(name = "VALID_FLAG", nullable = false, length = 1)
    private ValidFlag validFlag;


    public LetterSetUpEntity(@NonNull LetterSetUpKey letterSetUpKey,
                             @NonNull XslType xslType, @NonNull RendererType rendererType, @NonNull ValidFlag validFlag) {
        this.id = letterSetUpKey;
        this.xslType = xslType;
        this.rendererType = rendererType;
        this.validFlag = validFlag;
    }
}

