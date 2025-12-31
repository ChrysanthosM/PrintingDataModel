package org.masouras.model.mssql.schema.jpa.boundary;

import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.LetterSetUpEntity;
import org.masouras.model.mssql.schema.jpa.control.entity.LetterSetUpKey;
import org.masouras.model.mssql.schema.jpa.control.repository.LetterSetUpRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LetterSetUpService {
    private final LetterSetUpRepository letterSetUpRepository;

    @Transactional(readOnly = true)
    public List<LetterSetUpEntity> findAll() {
        return letterSetUpRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<LetterSetUpEntity> list(Pageable pageable) { return letterSetUpRepository.findAllBy(pageable).toList(); }

    @Transactional(readOnly = true)
    public Optional<LetterSetUpEntity> findById(LetterSetUpKey key) {
        return letterSetUpRepository.findById(key);
    }

    @Transactional
    public LetterSetUpEntity save(LetterSetUpEntity entity) {
        return letterSetUpRepository.save(entity);
    }

    @Transactional
    public void deleteById(LetterSetUpKey letterSetUpKey) {
        letterSetUpRepository.deleteById(letterSetUpKey);
    }
}
