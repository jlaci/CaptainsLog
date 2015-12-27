package hu.nextval.captainslog.web.backend.common.dto.regattas;

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

    protected long id;

    protected String name;

    protected Date startDate;

    protected Date endDate;

    protected List<RaceDTO> races;
}
