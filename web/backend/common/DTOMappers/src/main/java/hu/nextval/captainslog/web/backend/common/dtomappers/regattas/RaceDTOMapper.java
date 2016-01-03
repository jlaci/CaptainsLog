package hu.nextval.captainslog.web.backend.common.dtomappers.regattas;

import hu.nextval.captainslog.web.backend.common.dto.regattas.RaceDTO;
import hu.nextval.captainslog.web.backend.common.dtomappers.DTOMapper;
import hu.nextval.captainslog.web.backend.common.entities.regattas.Race;
import org.springframework.stereotype.Service;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Service
public class RaceDTOMapper implements DTOMapper<Race, RaceDTO>{

    @Override
    public RaceDTO mapTo(Race entity) {
        if(entity == null) {
            return null;
        }

        RaceDTO dto = new RaceDTO();

        dto.setId(entity.getId());
        dto.setType(entity.getRaceType().name());
        dto.setOrder(entity.getOrderInRegatta());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());

        return dto;
    }

    @Override
    public Race mapFrom(RaceDTO dto) {
        if(dto == null) {
            return null;
        }

        Race race = new Race();

        race.setId(dto.getId());
        race.setRaceType(Race.RaceType.valueOf(dto.getType()));
        race.setOrderInRegatta(dto.getOrder());
        race.setStartDate(dto.getStartDate());
        race.setEndDate(dto.getEndDate());

        return race;
    }
}
