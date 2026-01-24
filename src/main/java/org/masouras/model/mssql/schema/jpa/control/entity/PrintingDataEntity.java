package org.masouras.model.mssql.schema.jpa.control.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "PrintingDataTable")
@Data
@EqualsAndHashCode(exclude = "activity")
@NoArgsConstructor
public class PrintingDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REC_ID")
    private Long id;

    @NotNull
    @Column(name = "PRINTING_STATUS", nullable = false, length = 1)
    @Convert(converter = PrintingStatusConverter.class)
    private PrintingStatus printingStatus;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSS")
    @UpdateTimestamp
    @Column(name = "MODIFIED_AT", nullable = false)
    private LocalDateTime modifiedAt;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACTIVITY_ID", nullable = false)
    private ActivityEntity activity;

    @NotNull
    @Convert(converter = ContentTypeConverter.class)
    @Column(name = "CONTENT_TYPE", nullable = false, length = 5)
    private ContentType contentType;

    @NotNull
    @Convert(converter = FileExtensionTypeConverter.class)
    @Column(name = "EXTENSION_TYPE", nullable = false, length = 5)
    private FileExtensionType fileExtensionType;


    @Column(name = "ERROR_MESSAGE", length = 1024)
    private String errorMessage;

    @NotNull
    @OneToOne(optional = false)
    @JoinColumn(name = "INITIAL_CONTENT_ID", nullable = false)
    private PrintingFilesEntity initialContent;

    @OneToOne
    @JoinColumn(name = "VALIDATED_CONTENT_ID")
    private PrintingFilesEntity validatedContent;

    @OneToOne
    @JoinColumn(name = "FINAL_CONTENT_ID")
    private PrintingFilesEntity finalContent;

    public PrintingDataEntity(ActivityEntity activityEntity, ContentType contentType, FileExtensionType fileExtensionType, PrintingFilesEntity printingFilesEntity) {
        this.activity = activityEntity;
        this.contentType = contentType;
        this.fileExtensionType = fileExtensionType;
        this.initialContent = printingFilesEntity;
    }

    @PrePersist
    protected void onCreate() {
        this.printingStatus = PrintingStatus.INSERTED;
        this.modifiedAt = LocalDateTime.now();
    }
}
