package hu.nextval.captainslog.web.backend.common.dto.boats;

import hu.nextval.captainslog.web.backend.common.dto.clubs.ClubDTO;
import hu.nextval.captainslog.web.backend.common.dto.ports.PortDTO;
import hu.nextval.captainslog.web.backend.common.dto.sailors.SailorDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Getter
@Setter
public class BoatDTO {

    protected Long id;

    protected String name;

    protected String sailNumber;

    protected ClubDTO club;

    protected PortDTO port;

    protected SailorDTO owner;

}
