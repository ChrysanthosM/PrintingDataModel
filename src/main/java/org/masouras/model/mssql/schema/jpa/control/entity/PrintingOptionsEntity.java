package org.masouras.model.mssql.schema.jpa.control.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.PrintingOptionType;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.PrintingOptionTypeConverter;

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
    @Convert(converter = PrintingOptionTypeConverter.class)
    @Column(name = "OPTION_TYPE", nullable = false, length = 3)
    private PrintingOptionType printingOptionType;

    @Column(name = "OPTION_NAME")
    private String printingOptionName;

    @Column(name = "OPTION_VALUE")
    private String printingOptionValue;

    @Column(name = "OPTION_DETAILS")
    private String printingOptionDetails;
}

