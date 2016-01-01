package hu.nextval.captainslog.web.backend.common.dtomappers.ports;

import hu.nextval.captainslog.web.backend.common.dto.ports.PortDTO;
import hu.nextval.captainslog.web.backend.common.dtomappers.DTOMapper;
import hu.nextval.captainslog.web.backend.common.entities.ports.Port;
import org.springframework.stereotype.Service;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Service
public class PortDTOMapper implements DTOMapper<Port, PortDTO> {

    @Override
    public PortDTO mapTo(Port entity) {
        PortDTO dto = new PortDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }

    @Override
    public Port mapFrom(PortDTO dto) {
        Port port = new Port();

        port.setId(dto.getId());
        port.setName(dto.getName());

        return port;
    }
}
