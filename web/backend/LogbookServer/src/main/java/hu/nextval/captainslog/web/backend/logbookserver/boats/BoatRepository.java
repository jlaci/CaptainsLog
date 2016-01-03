package hu.nextval.captainslog.web.backend.logbookserver.boats;

import hu.nextval.captainslog.web.backend.common.entities.boats.Boat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
public interface BoatRepository extends CrudRepository<Boat, Long> {

    List<Boat> findByName(String name);

    @Query("SELECT b FROM Boat b INNER JOIN b.roster r WHERE r.id = (:sailorId)")
    List<Boat> findBySailor(@Param("sailorId") Long sailorId);
}
