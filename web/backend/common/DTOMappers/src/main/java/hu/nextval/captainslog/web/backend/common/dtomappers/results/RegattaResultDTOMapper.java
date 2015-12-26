package hu.nextval.captainslog.web.backend.common.dtomappers.results;

import hu.nextval.captainslog.web.backend.common.dto.results.RaceResultDTO;
import hu.nextval.captainslog.web.backend.common.dto.results.RegattaResultDTO;
import hu.nextval.captainslog.web.backend.common.dtomappers.DTOMapper;
import hu.nextval.captainslog.web.backend.common.entities.results.RaceResult;
import hu.nextval.captainslog.web.backend.common.entities.results.RegattaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Service
public class RegattaResultDTOMapper implements DTOMapper<RegattaResult, RegattaResultDTO> {

    @Autowired
    protected RaceResultDTOMapper raceResultDTOMapper;

    @Override
    public RegattaResultDTO mapTo(RegattaResult entity) {
        RegattaResultDTO dto = new RegattaResultDTO();

        dto.setBoatId(entity.getBoat().getId());
        dto.setRegattaId(entity.getRegatta().getId());
        dto.setRaceResults(new ArrayList<RaceResultDTO>(entity.getRaceResults().size()));

        for(RaceResult raceResult : entity.getRaceResults()) {
            dto.getRaceResults().add(raceResultDTOMapper.mapTo(raceResult));
        }

        return dto;
    }

    @Override
    public RegattaResult mapFrom(RegattaResultDTO dto) {
        throw new UnsupportedOperationException();
    }
}
