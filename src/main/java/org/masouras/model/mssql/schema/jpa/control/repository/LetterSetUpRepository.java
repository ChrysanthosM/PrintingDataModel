package org.masouras.model.mssql.schema.jpa.control.repository;

import org.masouras.model.mssql.schema.jpa.control.entity.LetterSetUpEntity;
import org.masouras.model.mssql.schema.jpa.control.entity.LetterSetUpKey;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterSetUpRepository extends JpaRepository<LetterSetUpEntity, LetterSetUpKey> {
    Slice<LetterSetUpEntity> findAllBy(Pageable pageable);
}
