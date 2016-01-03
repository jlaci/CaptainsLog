package hu.nextval.captainslog.web.backend.common.dtomappers.sailors;

import hu.nextval.captainslog.web.backend.common.dto.sailors.SailorDTO;
import hu.nextval.captainslog.web.backend.common.dtomappers.DTOMapper;
import hu.nextval.captainslog.web.backend.common.dtomappers.boats.BoatDTOMapper;
import hu.nextval.captainslog.web.backend.common.entities.sailor.Sailor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Service
public class SailorDTOMapper implements DTOMapper<Sailor, SailorDTO> {

    @Autowired
    protected BoatDTOMapper boatDTOMapper;

    @Override
    public SailorDTO mapTo(Sailor entity) {
        if(entity == null) {
            return null;
        }

        SailorDTO dto = new SailorDTO();

        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setId(entity.getId());

        return dto;
    }

    @Override
    public Sailor mapFrom(SailorDTO dto) {
        if(dto == null) {
            return null;
        }

        Sailor sailor = new Sailor();

        sailor.setId(dto.getId());
        sailor.setFirstName(dto.getFirstName());
        sailor.setLastName(dto.getLastName());

        return sailor;
    }
}
