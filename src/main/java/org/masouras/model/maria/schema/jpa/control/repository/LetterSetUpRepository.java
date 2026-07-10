package org.masouras.model.maria.schema.jpa.control.repository;

import org.masouras.model.maria.schema.jpa.control.entity.LetterSetUpEntity;
import org.masouras.model.maria.schema.jpa.control.entity.LetterSetUpKey;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LetterSetUpRepository extends JpaRepository<LetterSetUpEntity, LetterSetUpKey>, JpaSpecificationExecutor<LetterSetUpEntity> {
    Slice<LetterSetUpEntity> findAllBy(Pageable pageable);
}
