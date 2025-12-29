package org.masouras.model.mssql.schema.jpa.control.entity.adapter.projection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.*;

@RequiredArgsConstructor
@Getter
public class PrintingLetterSetUpProjectionImplementor implements PrintingLetterSetUpProjection {
    private final ActivityType activityType;
    private final ContentType contentType;
    private final LetterType letterType;
    private final XslType xslType;
    private final RendererType rendererType;
    private final ValidFlag validFlag;
}
