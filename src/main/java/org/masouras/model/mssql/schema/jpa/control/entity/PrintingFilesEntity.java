package org.masouras.model.mssql.schema.jpa.control.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(name = "CONTENT_BINARY")
    private byte[] contentBinary;

    public PrintingFilesEntity(byte[] contentBinary) {
        this.contentBinary = contentBinary;
    }
}
