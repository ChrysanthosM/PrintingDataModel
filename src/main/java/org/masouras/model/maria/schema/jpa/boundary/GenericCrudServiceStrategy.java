package org.masouras.model.maria.schema.jpa.boundary;

public sealed interface GenericCrudServiceStrategy<E, K> permits GenericCrudService {
    Class<E> getEntityClass();
    GenericCrudService<E, K> getGenericCrudService();
}
