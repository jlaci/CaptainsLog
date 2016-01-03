package hu.nextval.captainslog.web.backend.logbookserver.sailors;

import hu.nextval.captainslog.web.backend.common.entities.sailor.Sailor;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
public interface SailorRepository extends CrudRepository<Sailor, Long> {
}
