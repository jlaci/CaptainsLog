package hu.nextval.captainslog.web.backend.logbookserver.regattas.races;

import hu.nextval.captainslog.web.backend.common.entities.regattas.Race;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
public interface RaceRepository extends CrudRepository<Race, Long> {
}
