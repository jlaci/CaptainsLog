package hu.nextval.captainslog.web.backend.logbookserver.results;

import hu.nextval.captainslog.web.backend.common.entities.boats.Boat;
import hu.nextval.captainslog.web.backend.common.entities.results.RegattaResult;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@CommonsLog
@Service
public class RegattaResultService {

    @Autowired
    protected RegattaResultRepository regattaResultRepository;

    public List<RegattaResult> getAllByBoat(Boat boat) {
        if(boat == null) {
            throw new RegattaResultsServiceException("Boat must not be null!");
        }

        return regattaResultRepository.findByBoat(boat);
    }


    public static class RegattaResultsServiceException extends RuntimeException {
        public RegattaResultsServiceException() {
        }

        public RegattaResultsServiceException(String message) {
            super(message);
        }

        public RegattaResultsServiceException(String message, Throwable cause) {
            super(message, cause);
        }

        public RegattaResultsServiceException(Throwable cause) {
            super(cause);
        }

        public RegattaResultsServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}