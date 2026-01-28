package org.masouras.model.mssql.schema.jpa.control.entity.adapter.projection;

public interface ListToPrintProjection {
    Long getRecId();
    Long getFinalContentId();
    String getActivityType();
}
