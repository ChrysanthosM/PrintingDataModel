package org.masouras.model.mssql.schema.jpa.boundary;

import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.j2sql.boundary.PrintingDataSQLRepository;
import org.masouras.model.mssql.schema.jpa.control.entity.PrintingDataEntity;
import org.masouras.model.mssql.schema.jpa.control.entity.adapter.domain.ListToPrintDTO;
import org.masouras.model.mssql.schema.jpa.control.repository.PrintingDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrintingDataService {
    private final PrintingDataRepository printingDataRepository;
    private final PrintingDataSQLRepository printingDataSQLRepository;

    @Transactional
    public PrintingDataEntity save(PrintingDataEntity entity) {
        return printingDataRepository.save(entity);
    }

    @Transactional(readOnly = true)
    public List<ListToPrintDTO> getListToPrintDTOs() {
        return printingDataSQLRepository.getListToPrintDTOs();
    }

    @Transactional
    public int updateSetPrinted(List<Long> ids) {
        return printingDataSQLRepository.updateSetPrinted(ids);
    }
}
