package hu.nextval.captainslog.web.backend.logbookserver.ports;

import hu.nextval.captainslog.web.backend.common.entities.ports.Port;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
public interface PortRepository extends CrudRepository<Port, Long> {
}
