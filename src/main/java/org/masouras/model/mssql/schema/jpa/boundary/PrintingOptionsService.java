package org.masouras.model.mssql.schema.jpa.boundary;

import org.masouras.model.mssql.j2sql.boundary.PrintingOptionsSQLRepository;
import org.masouras.model.mssql.schema.jpa.control.entity.PrintingOptionsEntity;
import org.masouras.model.mssql.schema.jpa.control.entity.adapter.projection.PrintingLetterSetUpProjectionImplementor;
import org.masouras.model.mssql.schema.jpa.control.repository.PrintingOptionsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PrintingOptionsService extends GenericCrudService <PrintingOptionsEntity, Long> {
    private final PrintingOptionsSQLRepository printingOptionsSQLRepository;

    public PrintingOptionsService(PrintingOptionsRepository repository,
                                  PrintingOptionsSQLRepository printingOptionsSQLRepository) {
        super(PrintingOptionsEntity.class, repository, repository);
        this.printingOptionsSQLRepository = printingOptionsSQLRepository;
    }

    @Transactional(readOnly = true)
    public List<PrintingLetterSetUpProjectionImplementor> getPrintingLetterSetUpProjections() {
        return printingOptionsSQLRepository.getPrintingLetterSetUpProjections();
    }
}
