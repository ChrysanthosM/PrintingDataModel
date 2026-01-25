package org.masouras.model.mssql.schema.jpa.control.entity.adapter.mapper;

import org.masouras.model.mssql.schema.jpa.control.entity.ActivityEntity;
import org.masouras.model.mssql.schema.jpa.control.entity.PrintingDataEntity;
import org.masouras.model.mssql.schema.jpa.control.entity.PrintingFilesEntity;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.ContentType;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.FileExtensionType;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.PrintingStatus;
import org.masouras.model.mssql.schema.jpa.control.util.EnumUtil;
import org.masouras.model.mssql.schema.qb.structure.DbField;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class PrintingDataRowMapper implements RowMapper<PrintingDataEntity> {

    @Override
    public PrintingDataEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        PrintingDataEntity entity = new PrintingDataEntity();

        entity.setId(rs.getLong(DbField.REC_ID.systemName()));
        entity.setPrintingStatus(Objects.requireNonNull(EnumUtil.fromCode(PrintingStatus.class, rs.getString(DbField.PRINTING_STATUS.systemName()))));
        entity.setModifiedAt(rs.getTimestamp(DbField.MODIFIED_AT.systemName()).toLocalDateTime());

        ActivityEntity activity = new ActivityEntity();
        activity.setId(rs.getLong(DbField.ACTIVITY_ID.systemName()));
        entity.setActivity(activity);

        entity.setErrorMessage(rs.getString(DbField.ERROR_MESSAGE.systemName()));
        entity.setContentType(Objects.requireNonNull(EnumUtil.fromCode(ContentType.class, rs.getString(DbField.CONTENT_TYPE.systemName()))));
        entity.setFileExtensionType(Objects.requireNonNull(EnumUtil.fromCode(FileExtensionType.class, rs.getString(DbField.EXTENSION_TYPE.systemName()))));

        PrintingFilesEntity initialPrintingFilesEntity = new PrintingFilesEntity();
        initialPrintingFilesEntity.setId(rs.getLong(DbField.INITIAL_CONTENT_ID.systemName()));
        initialPrintingFilesEntity.setContentBinary(rs.getBytes(DbField.INITIAL_CONTENT_BINARY.systemName()));
        entity.setInitialContent(initialPrintingFilesEntity);

        long validatedId = rs.getLong(DbField.VALIDATED_CONTENT_ID.systemName());
        if (!rs.wasNull()) {
            PrintingFilesEntity validatedPrintingFilesEntity = new PrintingFilesEntity();
            validatedPrintingFilesEntity.setId(validatedId);
            validatedPrintingFilesEntity.setContentBinary(rs.getBytes(DbField.VALIDATED_CONTENT_BINARY.systemName()));
            entity.setValidatedContent(validatedPrintingFilesEntity);
        }

        long finalId = rs.getLong(DbField.FINAL_CONTENT_ID.systemName());
        if (!rs.wasNull()) {
            PrintingFilesEntity finalPrintingFilesEntity = new PrintingFilesEntity();
            finalPrintingFilesEntity.setId(finalId);
            finalPrintingFilesEntity.setContentBinary(rs.getBytes(DbField.FINAL_CONTENT_BINARY.systemName()));
            entity.setFinalContent(finalPrintingFilesEntity);
        }

        return entity;
    }
}
