package hu.nextval.captainslog.web.backend.logbookserver;

import hu.nextval.captainslog.web.backend.common.dtomappers.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
public abstract class GenericController<EntityType, DTOType> {

    @Autowired
    protected DTOMapper<EntityType, DTOType> dtoMapper;

    protected List<DTOType> asDTOList(List<EntityType> entities) {
        List<DTOType> result = new ArrayList<DTOType>(entities.size());

        for (EntityType entity : entities) {
            result.add(dtoMapper.mapTo(entity));
        }

        return result;
    }

}
