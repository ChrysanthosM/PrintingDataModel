package org.masouras.model.mssql.schema.jpa.control.util;

import jakarta.annotation.PostConstruct;
import org.masouras.model.mssql.schema.jpa.control.entity.enums.EnumTypeBase;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AssignableTypeFilter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class EnumPreloadAutoConfiguration {

    @PostConstruct
    public void preloadEnums() {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AssignableTypeFilter(EnumTypeBase.class));
        for (BeanDefinition bd : scanner.findCandidateComponents(getGroupId())) {
            try {
                Class<?> clazz = Class.forName(bd.getBeanClassName());
                if (clazz.isEnum() && EnumTypeBase.class.isAssignableFrom(clazz)) {
                    EnumUtil.preload(clazz);
                }
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Failed to load enum: " + bd.getBeanClassName(), e);
            }
        }
    }
    private String getGroupId() {
        try (InputStream input = getClass().getResourceAsStream("/application.properties")) {
            Properties props = new Properties();
            props.load(input);
            return props.getProperty("groupId");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
