package hu.nextval.captainslog.web.backend.common.dto.regattas;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Describes a regatta series
 *
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Getter
@Setter
public class RegattaSeriesDTO {

    protected Long id;

    protected String name;

    protected List<RegattaDTO> regattas;

}
