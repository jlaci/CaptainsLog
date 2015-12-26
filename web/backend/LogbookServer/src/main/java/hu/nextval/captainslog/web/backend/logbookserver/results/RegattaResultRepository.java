package hu.nextval.captainslog.web.backend.logbookserver.results;

import hu.nextval.captainslog.web.backend.common.entities.boats.Boat;
import hu.nextval.captainslog.web.backend.common.entities.results.RegattaResult;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
public interface RegattaResultRepository extends CrudRepository<RegattaResult, Long> {

    List<RegattaResult> findByBoat(Boat boat);
}
