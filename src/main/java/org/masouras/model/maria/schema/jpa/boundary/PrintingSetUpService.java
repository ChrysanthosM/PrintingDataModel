package org.masouras.model.maria.schema.jpa.boundary;

import org.masouras.model.maria.schema.jpa.control.entity.PrintingSetUpEntity;
import org.masouras.model.maria.schema.jpa.control.entity.PrintingSetUpKey;
import org.masouras.model.maria.schema.jpa.control.repository.PrintingSetUpRepository;
import org.springframework.stereotype.Service;

@Service
public class PrintingSetUpService extends GenericCrudService<PrintingSetUpEntity, PrintingSetUpKey> {
    public PrintingSetUpService(PrintingSetUpRepository repository) {
        super(PrintingSetUpEntity.class, repository, repository);
    }
}
