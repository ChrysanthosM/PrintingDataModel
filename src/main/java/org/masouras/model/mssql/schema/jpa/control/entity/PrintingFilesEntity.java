package org.masouras.model.mssql.schema.jpa.control.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "PrintingFilesTable")
@Data
@NoArgsConstructor
public class PrintingFilesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REC_ID")
    private Long id;

    @NotNull
    @Lob
    @Column(name = "CONTENT_BASE64")
    private String contentBase64;

    public PrintingFilesEntity(@NonNull String contentBase64) {
        this.contentBase64 = contentBase64;
    }
}
