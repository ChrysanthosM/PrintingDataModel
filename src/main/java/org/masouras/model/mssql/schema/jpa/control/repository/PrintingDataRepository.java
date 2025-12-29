package org.masouras.model.mssql.schema.jpa.control.repository;

import org.masouras.model.mssql.schema.jpa.control.entity.PrintingDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrintingDataRepository extends JpaRepository<PrintingDataEntity, Long> {}
