package hu.nextval.captainslog.web.backend.logbookserver.metamodell.service;

import com.google.common.collect.Lists;
import hu.nextval.captainslog.web.backend.common.entities.BaseEntity;
import hu.nextval.captainslog.web.backend.logbookserver.metamodell.CRUDOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
public abstract class BaseService <EntityType extends BaseEntity<IDType>, IDType extends Serializable> implements CRUDOperations<EntityType, IDType> {

    @Autowired
    protected CrudRepository<EntityType, IDType> repository;

    @Override
    public void create(EntityType entity) {
        if(entity == null) {
            throw new ServiceException("Entity must not be null!");
        }

        if(repository.exists(entity.getId())) {
            throw new ServiceException("Entity with id: " + entity.getId() + " already exists!");
        }

        repository.save(entity);
    }

    @Override
    public List<EntityType> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public EntityType getOne(IDType id) {
        if(id == null) {
            throw new ServiceException("ID must not be null!");
        }

        return repository.findOne(id);
    }

    @Override
    public EntityType update(IDType existingId, EntityType updated) {
        if(existingId == null) {
            throw new ServiceException("Existing ID must not be null!");
        }
        if(updated == null) {
            throw new ServiceException("Updated entity must not be null!");
        }

        EntityType existing = repository.findOne(existingId);

        if(existing == null) {
            throw new ServiceException("Existing entity with id " + existingId + " not found!");
        }

        updated.setId(existingId);

        return repository.save(updated);
    }

    @Override
    public void delete(IDType id) {
        if(id == null) {
            throw new ServiceException("ID must not be null!");
        }

        repository.delete(id);
    }


    public static class ServiceException extends RuntimeException {
        public ServiceException() {
        }

        public ServiceException(String message) {
            super(message);
        }

        public ServiceException(String message, Throwable cause) {
            super(message, cause);
        }

        public ServiceException(Throwable cause) {
            super(cause);
        }

        public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}
