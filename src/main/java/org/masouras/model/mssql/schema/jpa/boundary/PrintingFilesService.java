package org.masouras.model.mssql.schema.jpa.boundary;

import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.PrintingFilesEntity;
import org.masouras.model.mssql.schema.jpa.control.repository.PrintingFilesRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrintingFilesService {
    private final PrintingFilesRepository printingFilesRepository;

    public PrintingFilesEntity save(PrintingFilesEntity entity) {
        return printingFilesRepository.save(entity);
    }
}
