package org.masouras.model.mssql.schema.jpa.control.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "PrintingFilesTable")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class PrintingFilesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REC_ID")
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    @Lob
    @Column(name = "CONTENT_BINARY")
    private byte[] contentBinary;

    public PrintingFilesEntity(byte[] contentBinary) {
        this.contentBinary = contentBinary;
    }
}
