package org.masouras.model.mssql.schema.jpa.boundary;

import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.LetterSetUpEntity;
import org.masouras.model.mssql.schema.jpa.control.entity.LetterSetUpKey;
import org.masouras.model.mssql.schema.jpa.control.repository.LetterSetUpRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LetterSetUpService {
    private final LetterSetUpRepository letterSetUpRepository;

    public List<LetterSetUpEntity> findAll() {
        return letterSetUpRepository.findAll();
    }
    public Optional<LetterSetUpEntity> findById(LetterSetUpKey key) {
        return letterSetUpRepository.findById(key);
    }
    public LetterSetUpEntity save(LetterSetUpEntity entity) {
        return letterSetUpRepository.save(entity);
    }
    public void deleteById(LetterSetUpKey letterSetUpKey) {
        letterSetUpRepository.deleteById(letterSetUpKey);
    }
}
