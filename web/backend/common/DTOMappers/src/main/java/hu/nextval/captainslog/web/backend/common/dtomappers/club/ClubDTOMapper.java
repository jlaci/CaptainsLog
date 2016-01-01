package hu.nextval.captainslog.web.backend.common.dtomappers.club;

import hu.nextval.captainslog.web.backend.common.dto.clubs.ClubDTO;
import hu.nextval.captainslog.web.backend.common.dtomappers.DTOMapper;
import hu.nextval.captainslog.web.backend.common.entities.clubs.Club;
import org.springframework.stereotype.Service;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Service
public class ClubDTOMapper implements DTOMapper<Club, ClubDTO> {

    @Override
    public ClubDTO mapTo(Club entity) {
        ClubDTO dto = new ClubDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }

    @Override
    public Club mapFrom(ClubDTO dto) {
        Club entity = new Club();

        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }
}
