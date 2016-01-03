package hu.nextval.captainslog.web.backend.common.dtomappers.boats;

import hu.nextval.captainslog.web.backend.common.dto.boats.BoatDTO;
import hu.nextval.captainslog.web.backend.common.dtomappers.DTOMapper;
import hu.nextval.captainslog.web.backend.common.dtomappers.club.ClubDTOMapper;
import hu.nextval.captainslog.web.backend.common.dtomappers.ports.PortDTOMapper;
import hu.nextval.captainslog.web.backend.common.dtomappers.sailors.SailorDTOMapper;
import hu.nextval.captainslog.web.backend.common.entities.boats.Boat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Service
public class BoatDTOMapper implements DTOMapper<Boat, BoatDTO> {

    @Autowired
    protected SailorDTOMapper sailorDTOMapper;

    @Autowired
    protected PortDTOMapper portDTOMapper;

    @Autowired
    protected ClubDTOMapper clubDTOMapper;

    @Override
    public BoatDTO mapTo(Boat entity) {
        if(entity == null) {
            return null;
        }

        BoatDTO dto = new BoatDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSailNumber(entity.getSailNumber());
        dto.setPort(portDTOMapper.mapTo(entity.getPort()));
        dto.setOwner(sailorDTOMapper.mapTo(entity.getOwner()));
        dto.setClub(clubDTOMapper.mapTo(entity.getClub()));

        return dto;
    }

    @Override
    public Boat mapFrom(BoatDTO dto) {
        if(dto == null) {
            return null;
        }

        Boat boat = new Boat();

        boat.setId(dto.getId());
        boat.setName(dto.getName());
        boat.setSailNumber(dto.getSailNumber());
        boat.setOwner(sailorDTOMapper.mapFrom(dto.getOwner()));
        boat.setPort(portDTOMapper.mapFrom(dto.getPort()));
        boat.setClub(clubDTOMapper.mapFrom(dto.getClub()));

        return boat;
    }
}
