package org.masouras.model.mssql.schema.jpa.control.repository;

import org.masouras.model.mssql.schema.jpa.control.entity.BatchStatisticsDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BatchStatisticsDetailsRepository extends JpaRepository<BatchStatisticsDetailsEntity, Long>, JpaSpecificationExecutor<BatchStatisticsDetailsEntity> {}
