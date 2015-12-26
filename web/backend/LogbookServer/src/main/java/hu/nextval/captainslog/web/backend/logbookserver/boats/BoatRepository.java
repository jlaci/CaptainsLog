package hu.nextval.captainslog.web.backend.logbookserver.boats;

import hu.nextval.captainslog.web.backend.common.entities.boats.Boat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
public interface BoatRepository extends CrudRepository<Boat, Long> {

    List<Boat> findByName(String name);
}
