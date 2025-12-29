package org.masouras.model.mssql.schema.jpa.boundary;

import lombok.RequiredArgsConstructor;
import org.masouras.model.mssql.schema.jpa.control.entity.ActivityEntity;
import org.masouras.model.mssql.schema.jpa.control.repository.ActivityRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;

    public ActivityEntity save(ActivityEntity entity) {
        return activityRepository.save(entity);
    }
}
