package hu.nextval.captainslog.web.backend.common.dtomappers.regattas;

import hu.nextval.captainslog.web.backend.common.dto.regattas.RaceDTO;
import hu.nextval.captainslog.web.backend.common.dto.regattas.RegattaDTO;
import hu.nextval.captainslog.web.backend.common.dtomappers.DTOMapper;
import hu.nextval.captainslog.web.backend.common.dtomappers.club.ClubDTOMapper;
import hu.nextval.captainslog.web.backend.common.entities.regattas.Race;
import hu.nextval.captainslog.web.backend.common.entities.regattas.Regatta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Service
public class RegattaDTOMapper implements DTOMapper<Regatta, RegattaDTO>{

    @Autowired
    protected RaceDTOMapper raceDTOMapper;

    @Autowired
    protected ClubDTOMapper clubDTOMapper;

    @Override
    public RegattaDTO mapTo(Regatta entity) {
        RegattaDTO dto = new RegattaDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setType(entity.getRegattaType().name());
        dto.setLocation(entity.getLocation());
        dto.setOrganizer(clubDTOMapper.mapTo(entity.getOrganizer()));
        dto.setRaces(new ArrayList<RaceDTO>(entity.getRaces().size()));

        for(Race race : entity.getRaces()) {
            dto.getRaces().add(raceDTOMapper.mapTo(race));
        }

        return dto;
    }

    @Override
    public Regatta mapFrom(RegattaDTO dto) {
        if(dto != null) {
            Regatta regatta = new Regatta();
            regatta.setId(dto.getId());
            regatta.setName(dto.getName());
            regatta.setStartDate(dto.getStartDate());
            regatta.setEndDate(dto.getEndDate());
            regatta.setRegattaType(Regatta.RegattaType.valueOf(dto.getType()));
            regatta.setLocation(dto.getLocation());
            regatta.setOrganizer(clubDTOMapper.mapFrom(dto.getOrganizer()));
            regatta.setRaces(new ArrayList<Race>());

            if (dto.getRaces() != null) {
                for (RaceDTO raceDTO : dto.getRaces()) {
                    Race race = raceDTOMapper.mapFrom(raceDTO);
                    race.setRegatta(regatta);
                    regatta.getRaces().add(race);
                }
            }
            return regatta;
        } else {
            return null;
        }
    }
}
