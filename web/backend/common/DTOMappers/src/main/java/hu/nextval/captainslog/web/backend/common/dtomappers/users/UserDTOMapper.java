package hu.nextval.captainslog.web.backend.common.dtomappers.users;

import hu.nextval.captainslog.web.backend.common.dto.users.UserDTO;
import hu.nextval.captainslog.web.backend.common.dtomappers.DTOMapper;
import hu.nextval.captainslog.web.backend.common.dtomappers.sailors.SailorDTOMapper;
import hu.nextval.captainslog.web.backend.common.entities.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Service
public class UserDTOMapper implements DTOMapper<User, UserDTO> {

    @Autowired
    protected SailorDTOMapper sailorDTOMapper;

    @Override
    public UserDTO mapTo(User entity) {
        if(entity == null) {
            return null;
        }

        UserDTO dto = new UserDTO();

        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setId(entity.getId());
        dto.setSailor(sailorDTOMapper.mapTo(entity.getSailor()));

        return dto;
    }

    @Override
    public User mapFrom(UserDTO dto) {
        if(dto == null) {
            return null;
        }

        User entity = new User();

        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setSailor(sailorDTOMapper.mapFrom(dto.getSailor()));

        //Id is intentionally not set when mapping back, it should be always obtained from the security context.

        return entity;
    }
}
