package org.masouras.model.mssql.schema.jpa.boundary;

import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.PrintingDataEntity;
import org.masouras.model.mssql.schema.jpa.control.repository.PrintingDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PrintingDataService {
    private final PrintingDataRepository printingDataRepository;

    @Transactional
    public PrintingDataEntity save(PrintingDataEntity entity) {
        return printingDataRepository.save(entity);
    }
}
