package hu.nextval.captainslog.web.backend.logbookserver.results;

import hu.nextval.captainslog.web.backend.common.dto.results.RegattaResultDTO;
import hu.nextval.captainslog.web.backend.common.entities.boats.Boat;
import hu.nextval.captainslog.web.backend.common.entities.results.RegattaResult;
import hu.nextval.captainslog.web.backend.logbookserver.GenericController;
import hu.nextval.captainslog.web.backend.logbookserver.boats.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@RestController
public class RegattaResultController extends GenericController<RegattaResult, RegattaResultDTO> {

    @Autowired
    protected RegattaResultService regattaResultService;

    @Autowired
    protected BoatService boatService;

    @RequestMapping(method = RequestMethod.GET, path = "boats/{boatId}/results/regatta/all")
    List<RegattaResultDTO> getAllForBoat(@PathParam("boatId")long boatId){
        Boat boat = boatService.getOne(boatId);

        if(boat == null) {
            throw new NoSuchBoatException();
        }

        return asDTOList(regattaResultService.getAllByBoat(boat));
    }


    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such boat found!")
    public class NoSuchBoatException extends RuntimeException { }
}
