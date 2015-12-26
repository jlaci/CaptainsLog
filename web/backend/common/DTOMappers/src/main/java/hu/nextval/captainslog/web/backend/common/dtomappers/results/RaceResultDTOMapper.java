package hu.nextval.captainslog.web.backend.common.dtomappers.results;

import hu.nextval.captainslog.web.backend.common.dto.results.RaceResultDTO;
import hu.nextval.captainslog.web.backend.common.dtomappers.DTOMapper;
import hu.nextval.captainslog.web.backend.common.entities.results.RaceResult;
import org.springframework.stereotype.Service;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Service
public class RaceResultDTOMapper implements DTOMapper<RaceResult, RaceResultDTO> {

    @Override
    public RaceResultDTO mapTo(RaceResult entity) {
        RaceResultDTO dto = new RaceResultDTO();

        return dto;
    }

    @Override
    public RaceResult mapFrom(RaceResultDTO dto) {
        throw new UnsupportedOperationException();
    }
}
