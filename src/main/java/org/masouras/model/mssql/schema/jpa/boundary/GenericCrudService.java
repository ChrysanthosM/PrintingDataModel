package org.masouras.model.mssql.schema.jpa.boundary;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class GenericCrudService<T, ID> {
    protected final JpaRepository<T, ID> jpaRepository;
    protected final JpaSpecificationExecutor<T> jpaSpecificationExecutor;

    protected GenericCrudService(JpaRepository<T, ID> jpaRepository, JpaSpecificationExecutor<T> jpaSpecificationExecutor) {
        this.jpaRepository = jpaRepository;
        this.jpaSpecificationExecutor = jpaSpecificationExecutor;
    }

    @Transactional(readOnly = true)
    public Optional<T> findById(ID key) {
        return jpaRepository.findById(key);
    }

    @Transactional(readOnly = true)
    public List<T> findAll() {
        return jpaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<T> findAll(Pageable pageable, Specification<T> spec) {
        return jpaSpecificationExecutor.findAll(spec, pageable);
    }

    @Transactional
    public T save(T entity) {
        return jpaRepository.save(entity);
    }

    @Transactional
    public void deleteAll(List<T> entities) {
        jpaRepository.deleteAll(entities);
    }
}
