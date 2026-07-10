package org.masouras.model.maria.schema.jpa.control.repository;

import org.masouras.model.maria.schema.jpa.control.entity.PrintingSetUpEntity;
import org.masouras.model.maria.schema.jpa.control.entity.PrintingSetUpKey;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrintingSetUpRepository extends JpaRepository<PrintingSetUpEntity, PrintingSetUpKey>, JpaSpecificationExecutor<PrintingSetUpEntity> {
    Slice<PrintingSetUpEntity> findAllBy(Pageable pageable);
}
