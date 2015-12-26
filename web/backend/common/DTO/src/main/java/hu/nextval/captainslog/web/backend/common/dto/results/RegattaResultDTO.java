package hu.nextval.captainslog.web.backend.common.dto.results;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Getter
@Setter
public class RegattaResultDTO {

    protected long regattaId;

    protected List<RaceResultDTO> raceResults;

    protected long boatId;
}
