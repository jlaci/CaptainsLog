package hu.nextval.captainslog.web.backend.logbookserver.clubs;

import hu.nextval.captainslog.web.backend.common.entities.clubs.Club;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
public interface ClubRepository extends CrudRepository<Club, Long> {
}
