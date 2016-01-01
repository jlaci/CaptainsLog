package hu.nextval.captainslog.web.backend.common.dto.regattas;

import hu.nextval.captainslog.web.backend.common.dto.clubs.ClubDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Getter
@Setter
public class RegattaDTO {

    protected Long id;

    protected String name;

    protected String type;

    protected String location;

    protected ClubDTO organizer;

    protected Date startDate;

    protected Date endDate;

    protected List<RaceDTO> races;
}
