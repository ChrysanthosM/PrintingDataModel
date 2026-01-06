package org.masouras.model.mssql.schema.jpa.control.entity;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.textfield.TextField;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.PrintingOptionType;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.PrintingOptionTypeConverter;
import org.masouras.model.mssql.schema.jpa.control.vaadin.FormField;

@Entity
@Table(name = "PrintingOptionsTable")
@Data
@NoArgsConstructor
public class PrintingOptionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REC_ID")
    private Long id;

    @NotNull
    @FormField(component = ComboBox.class, label = "Option Type", required = true, order = 1)
    @Convert(converter = PrintingOptionTypeConverter.class)
    @Column(name = "OPTION_TYPE", nullable = false, length = 3)
    private PrintingOptionType printingOptionType;

    @FormField(component = TextField.class, label = "Option Name", order = 2)
    @Column(name = "OPTION_NAME")
    private String printingOptionName;

    @FormField(component = TextField.class, label = "Option Value", order = 3)
    @Column(name = "OPTION_VALUE")
    private String printingOptionValue;

    @FormField(component = TextField.class, label = "Option Details", order = 4)
    @Column(name = "OPTION_DETAILS")
    private String printingOptionDetails;
}

