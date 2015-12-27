package hu.nextval.captainslog.web.backend.common.dto.regattas;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Getter
@Setter
public class RaceDTO {

    protected long id;

    protected String type;

    protected Date startDate;

    protected Date endDate;

}
