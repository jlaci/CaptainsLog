package hu.nextval.captainslog.web.backend.common.dtomappers.regattas;

import hu.nextval.captainslog.web.backend.common.dto.regattas.RegattaDTO;
import hu.nextval.captainslog.web.backend.common.dto.regattas.RegattaSeriesDTO;
import hu.nextval.captainslog.web.backend.common.dtomappers.DTOMapper;
import hu.nextval.captainslog.web.backend.common.entities.regattas.Regatta;
import hu.nextval.captainslog.web.backend.common.entities.regattas.RegattaSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Service
public class RegattaSeriesDTOMapper implements DTOMapper<RegattaSeries, RegattaSeriesDTO>{

    @Autowired
    protected RegattaDTOMapper regattaDTOMapper;

    @Override
    public RegattaSeriesDTO mapTo(RegattaSeries entity) {
        if(entity == null) {
            return null;
        }

        RegattaSeriesDTO dto = new RegattaSeriesDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setRegattas(new ArrayList<RegattaDTO>());

        for(Regatta regatta : entity.getRegattas()) {
            dto.getRegattas().add(regattaDTOMapper.mapTo(regatta));
        }

        return dto;
    }

    @Override
    public RegattaSeries mapFrom(RegattaSeriesDTO dto) {
        if(dto == null) {
            return null;
        }

        RegattaSeries regattaSeries = new RegattaSeries();

        if(dto != null) {
            regattaSeries.setId(dto.getId());
            regattaSeries.setName(dto.getName());
            regattaSeries.setRegattas(new ArrayList<Regatta>());

            if (dto.getRegattas() != null) {
                for (RegattaDTO regattaDTO : dto.getRegattas()) {
                    Regatta regatta = regattaDTOMapper.mapFrom(regattaDTO);
                    regattaSeries.getRegattas().add(regatta);
                }
            }
        }
        return regattaSeries;
    }
}
