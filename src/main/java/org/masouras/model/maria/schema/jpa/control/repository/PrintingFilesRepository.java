package org.masouras.model.maria.schema.jpa.control.repository;

import org.masouras.model.maria.schema.jpa.control.entity.PrintingFilesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrintingFilesRepository extends JpaRepository<PrintingFilesEntity, Long>, JpaSpecificationExecutor<PrintingFilesEntity> {}
