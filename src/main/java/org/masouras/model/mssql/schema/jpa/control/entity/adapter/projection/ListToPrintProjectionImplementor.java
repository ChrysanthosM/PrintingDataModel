package org.masouras.model.mssql.schema.jpa.control.entity.adapter.projection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ListToPrintProjectionImplementor implements ListToPrintProjection {
    private final Long RecId;
    private final Long FinalContentId;
    private final String ActivityType;
}
