package org.masouras.model.mssql.schema.jpa.control.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "BatchStatisticsDetailsTable")
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BatchStatisticsDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REC_ID")
    private Long id;

    @NotNull
    @Column(name = "JOB_EXECUTION_ID", nullable = false)
    private Long jobExecutionID;

    @NotNull
    @Column(name = "STEP_NAME", nullable = false, length = 50)
    private String stepName;

    @NotNull
    @Column(name = "EXIT_STATUS", nullable = false, length = 10)
    private String exitStatus;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSS")
    @Column(name = "START_TIME")
    private LocalDateTime startTime;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSS")
    @Column(name = "END_TIME")
    private LocalDateTime endTime;

    @NotNull
    @Column(name = "DURATION_MS", nullable = false)
    private Long durationMS;

    @NotNull
    @Column(name = "READ_COUNT", nullable = false)
    private Long readCount;

    @NotNull
    @Column(name = "WRITE_COUNT", nullable = false)
    private Long writeCount;

    @NotNull
    @Column(name = "COMMIT_COUNT", nullable = false)
    private Long commitCount;

    @NotNull
    @Column(name = "ROLLBACK_COUNT", nullable = false)
    private Long rollbackCount;

    @NotNull
    @Column(name = "SKIP_COUNT", nullable = false)
    private Long skipCount;

    @NotNull
    @Column(name = "READ_SKIP_COUNT", nullable = false)
    private Long readSkipCount;

    @NotNull
    @Column(name = "WRITE_SKIP_COUNT", nullable = false)
    private Long writeSkipCount;

    @NotNull
    @Column(name = "FILTER_COUNT", nullable = false)
    private Long filterCount;
}

