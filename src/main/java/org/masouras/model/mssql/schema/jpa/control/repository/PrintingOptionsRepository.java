package org.masouras.model.mssql.schema.jpa.control.repository;

import org.masouras.model.mssql.schema.jpa.control.entity.PrintingOptionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrintingOptionsRepository extends JpaRepository<PrintingOptionsEntity, Long> {}
