package org.masouras.model.maria.schema.jpa.control.entity.adapter.projection;

import org.masouras.model.maria.schema.jpa.control.entity.enums.*;

public interface PrintingLetterSetUpProjection {
    ActivityType getActivityType();
    ContentType getContentType();
    LetterType getLetterType();
    XslType getXslType();
    RendererType getRendererType();
    ValidFlag getValidFlag();
}
