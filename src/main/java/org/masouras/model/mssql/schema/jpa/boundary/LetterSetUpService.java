package org.masouras.model.mssql.schema.jpa.boundary;

import org.masouras.model.mssql.schema.jpa.control.entity.LetterSetUpEntity;
import org.masouras.model.mssql.schema.jpa.control.entity.LetterSetUpKey;
import org.masouras.model.mssql.schema.jpa.control.repository.LetterSetUpRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LetterSetUpService extends GenericCrudService<LetterSetUpEntity, LetterSetUpKey> {
    private final LetterSetUpRepository repository;

    public LetterSetUpService(LetterSetUpRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<LetterSetUpEntity> list(Pageable pageable) {
        return repository.findAllBy(pageable).toList();
    }
}
