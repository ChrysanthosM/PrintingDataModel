package org.masouras.model.mssql.schema.jpa.boundary;

import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.LetterSetUpEntity;
import org.masouras.model.mssql.schema.jpa.control.entity.LetterSetUpKey;
import org.masouras.model.mssql.schema.jpa.control.entity.PrintingSetUpEntity;
import org.masouras.model.mssql.schema.jpa.control.entity.PrintingSetUpKey;
import org.masouras.model.mssql.schema.jpa.control.repository.LetterSetUpRepository;
import org.masouras.model.mssql.schema.jpa.control.repository.PrintingSetUpRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrintingSetUpService {
    private final PrintingSetUpRepository printingSetUpRepository;

    @Transactional(readOnly = true)
    public List<PrintingSetUpEntity> findAll() {
        return printingSetUpRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<PrintingSetUpEntity> list(Pageable pageable) { return printingSetUpRepository.findAllBy(pageable).toList(); }

    @Transactional(readOnly = true)
    public Optional<PrintingSetUpEntity> findById(PrintingSetUpKey key) {
        return printingSetUpRepository.findById(key);
    }

    @Transactional
    public PrintingSetUpEntity save(PrintingSetUpEntity entity) {
        return printingSetUpRepository.save(entity);
    }

    @Transactional
    public void deleteById(PrintingSetUpKey letterSetUpKey) {
        printingSetUpRepository.deleteById(letterSetUpKey);
    }
}
