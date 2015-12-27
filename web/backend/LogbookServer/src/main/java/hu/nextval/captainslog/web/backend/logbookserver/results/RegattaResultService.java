package hu.nextval.captainslog.web.backend.logbookserver.results;

import hu.nextval.captainslog.web.backend.common.entities.boats.Boat;
import hu.nextval.captainslog.web.backend.common.entities.results.RegattaResult;
import hu.nextval.captainslog.web.backend.logbookserver.metamodell.service.BaseService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@CommonsLog
@Service
public class RegattaResultService extends BaseService<RegattaResult, Long> {

    @Autowired
    protected RegattaResultRepository regattaResultRepository;

    public List<RegattaResult> getAllByBoat(Boat boat) {
        if(boat == null) {
            throw new ServiceException("Boat must not be null!");
        }

        return regattaResultRepository.findByBoat(boat);
    }

}