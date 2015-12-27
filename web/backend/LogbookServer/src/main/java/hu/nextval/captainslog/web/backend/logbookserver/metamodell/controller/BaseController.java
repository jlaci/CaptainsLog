package hu.nextval.captainslog.web.backend.logbookserver.metamodell.controller;

import hu.nextval.captainslog.web.backend.common.dtomappers.DTOMapper;
import hu.nextval.captainslog.web.backend.common.entities.BaseEntity;
import hu.nextval.captainslog.web.backend.logbookserver.metamodell.CRUDOperations;
import hu.nextval.captainslog.web.backend.logbookserver.metamodell.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
public abstract class BaseController<EntityType extends BaseEntity<IDType>, IDType extends Serializable, DTOType> implements CRUDOperations<DTOType, IDType> {

    @Autowired
    protected DTOMapper<EntityType, DTOType> dtoMapper;

    @Autowired
    protected BaseService<EntityType, IDType> service;


    @Override
    public void create(DTOType entity) {
        service.create(dtoMapper.mapFrom(entity));
    }

    @Override
    public List<DTOType> getAll() {
        return asDTOList(service.getAll());
    }

    @Override
    public DTOType getOne(IDType id) {
        try {
            return dtoMapper.mapTo(service.getOne(id));
        } catch (BaseService.ServiceException se) {
            throw new GetOneFailedException(se);
        }
    }

    @Override
    public DTOType update(IDType existingId, DTOType updated) {
        try {
            return dtoMapper.mapTo(service.update(existingId, dtoMapper.mapFrom(updated)));
        } catch (BaseService.ServiceException se) {
            throw new UpdateFailedException(se);
        }
    }

    @Override
    public void delete(IDType id) {
        service.delete(id);
    }

    protected List<DTOType> asDTOList(List<EntityType> entities) {
        List<DTOType> result = new ArrayList<DTOType>(entities.size());

        for (EntityType entity : entities) {
            result.add(dtoMapper.mapTo(entity));
        }

        return result;
    }


    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Update failed!")
    public static class UpdateFailedException extends RuntimeException {
        public UpdateFailedException(Throwable cause) {
            super(cause);
        }
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "GetAll failed!")
    public static class GetOneFailedException extends RuntimeException {
        public GetOneFailedException(Throwable cause) {
            super(cause);
        }
    }
}
