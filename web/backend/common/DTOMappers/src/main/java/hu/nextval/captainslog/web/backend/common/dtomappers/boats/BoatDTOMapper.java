package hu.nextval.captainslog.web.backend.common.dtomappers.boats;

import hu.nextval.captainslog.web.backend.common.dto.boats.BoatDTO;
import hu.nextval.captainslog.web.backend.common.dtomappers.DTOMapper;
import hu.nextval.captainslog.web.backend.common.entities.boats.Boat;
import org.springframework.stereotype.Service;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Service
public class BoatDTOMapper implements DTOMapper<Boat, BoatDTO> {

    @Override
    public BoatDTO mapTo(Boat entity) {
        BoatDTO dto = new BoatDTO();

        dto.setId(dto.getId());
        dto.setName(entity.getName());

        return dto;
    }

    @Override
    public Boat mapFrom(BoatDTO dto) {
        Boat boat = new Boat();

        boat.setId(dto.getId());
        boat.setName(dto.getName());

        return boat;
    }
}
