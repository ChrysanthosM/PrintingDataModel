package org.masouras.model.mssql.schema.jpa.boundary;

import org.masouras.model.mssql.schema.jpa.control.entity.LetterSetUpEntity;
import org.masouras.model.mssql.schema.jpa.control.entity.LetterSetUpKey;
import org.masouras.model.mssql.schema.jpa.control.repository.LetterSetUpRepository;
import org.springframework.stereotype.Service;

@Service
public class LetterSetUpService extends GenericCrudService<LetterSetUpEntity, LetterSetUpKey> {
    public LetterSetUpService(LetterSetUpRepository repository) {
        super(repository, repository);
    }
}
