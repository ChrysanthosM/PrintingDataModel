package org.masouras.model.mssql.schema.jpa.control.repository;

import org.masouras.model.mssql.schema.jpa.control.entity.PrintingDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrintingDataRepository extends JpaRepository<PrintingDataEntity, Long>, JpaSpecificationExecutor<PrintingDataEntity> {}
