package de.qhun.stackoverflow.spring_boot_mongo_domain_access_layer.domain;

import de.qhun.stackoverflow.spring_boot_mongo_domain_access_layer.config.ApplicationContextHolder;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.repository.MongoRepository;

abstract class DomainObject<D extends DomainObject<D, R>, R extends MongoRepository<D, ?>> {

    @Transient
    private final Class<R> repositoryClass;

    @Transient
    private R repository;

    DomainObject(Class<R> repository) {
        repositoryClass = repository;
    }

    public D save() {
        //noinspection unchecked
        return repository().save((D) this);
    }

    @Transient
    protected R repository() {
        if (repository == null) {
            repository = repository(repositoryClass);
        }
        return repository;
    }

    @Transient
    protected <T extends MongoRepository<? extends DomainObject<?, T>, ?>> T repository(Class<T> repository) {
        return ApplicationContextHolder.getContext().getBean(repository);
    }

}
