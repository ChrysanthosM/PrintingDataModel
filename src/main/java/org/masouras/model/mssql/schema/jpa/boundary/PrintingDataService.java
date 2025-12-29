package org.masouras.model.mssql.schema.jpa.boundary;

import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.PrintingDataEntity;
import org.masouras.model.mssql.schema.jpa.control.repository.PrintingDataRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrintingDataService {
    private final PrintingDataRepository printingDataRepository;

    public PrintingDataEntity save(PrintingDataEntity entity) {
        return printingDataRepository.save(entity);
    }
}
