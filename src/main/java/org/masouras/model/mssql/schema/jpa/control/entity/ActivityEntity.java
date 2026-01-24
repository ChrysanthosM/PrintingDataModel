package org.masouras.model.mssql.schema.jpa.control.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.ActivityType;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.ActivityTypeConverter;

import java.time.LocalDateTime;

@Entity
@Table(name = "ActivityTable")
@Data
@NoArgsConstructor
public class ActivityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REC_ID")
    private Long id;

    @NotNull
    @Convert(converter = ActivityTypeConverter.class)
    @Column(name = "ACTIVITY_TYPE", nullable = false, length = 5)
    private ActivityType activityType;

    @NotNull
    @Column(name = "PGM_STAMP", nullable = false)
    private String pgmStamp;

    @NotNull
    @Column(name = "USER_STAMP", nullable = false)
    private String userStamp;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSS")
    @Column(name = "DATE_STAMP", nullable = false)
    private LocalDateTime dateStamp;

    public ActivityEntity(@NonNull ActivityType activityType, String pgmStamp, String userStamp, LocalDateTime dateStamp) {
        this.activityType = activityType;
        this.pgmStamp = pgmStamp;
        this.userStamp = userStamp;
        this.dateStamp = dateStamp;
    }
}

