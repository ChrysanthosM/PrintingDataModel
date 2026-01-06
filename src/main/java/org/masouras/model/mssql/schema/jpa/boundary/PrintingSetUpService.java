package org.masouras.model.mssql.schema.jpa.boundary;

import org.masouras.model.mssql.schema.jpa.control.entity.PrintingSetUpEntity;
import org.masouras.model.mssql.schema.jpa.control.entity.PrintingSetUpKey;
import org.masouras.model.mssql.schema.jpa.control.repository.PrintingSetUpRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PrintingSetUpService extends GenericCrudService<PrintingSetUpEntity, PrintingSetUpKey> {
    private final PrintingSetUpRepository repository;

    public PrintingSetUpService(PrintingSetUpRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<PrintingSetUpEntity> list(Pageable pageable) {
        return repository.findAllBy(pageable).toList();
    }
}
