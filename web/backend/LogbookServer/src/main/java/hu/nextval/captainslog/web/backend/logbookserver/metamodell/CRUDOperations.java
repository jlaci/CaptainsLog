package hu.nextval.captainslog.web.backend.logbookserver.metamodell;

import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
public interface CRUDOperations<Type, IDType> {

    void create(Type entity);

    List<Type> getAll();

    Type getOne(IDType id);

    Type update(IDType existingId, Type updated);

    void delete(IDType id);


}
