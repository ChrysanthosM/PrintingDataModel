package org.masouras.model.mssql.schema.jpa.control.repository;

import org.masouras.model.mssql.schema.jpa.control.entity.PrintingSetUpEntity;
import org.masouras.model.mssql.schema.jpa.control.entity.PrintingSetUpKey;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrintingSetUpRepository extends JpaRepository<PrintingSetUpEntity, PrintingSetUpKey> {
    Slice<PrintingSetUpEntity> findAllBy(Pageable pageable);
}
