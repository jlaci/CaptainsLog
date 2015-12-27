package hu.nextval.captainslog.web.backend.logbookserver.regattas;

import hu.nextval.captainslog.web.backend.common.entities.regattas.Regatta;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
public interface RegattaRepository extends CrudRepository<Regatta, Long> {
}
