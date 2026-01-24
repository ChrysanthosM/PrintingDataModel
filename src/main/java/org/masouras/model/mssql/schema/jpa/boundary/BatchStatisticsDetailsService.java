package org.masouras.model.mssql.schema.jpa.boundary;

import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.BatchStatisticsDetailsEntity;
import org.masouras.model.mssql.schema.jpa.control.repository.BatchStatisticsDetailsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BatchStatisticsDetailsService {
    private final BatchStatisticsDetailsRepository batchStatisticsDetailsRepository;

    @Transactional
    public BatchStatisticsDetailsEntity save(BatchStatisticsDetailsEntity entity) {
        return batchStatisticsDetailsRepository.save(entity);
    }
}
