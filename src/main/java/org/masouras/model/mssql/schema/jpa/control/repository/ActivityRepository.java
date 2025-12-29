package org.masouras.model.mssql.schema.jpa.control.repository;

import org.masouras.model.mssql.schema.jpa.control.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {}
