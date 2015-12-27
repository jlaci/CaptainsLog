package hu.nextval.captainslog.web.backend.logbookserver.results;

import hu.nextval.captainslog.web.backend.common.dto.results.RegattaResultDTO;
import hu.nextval.captainslog.web.backend.common.entities.boats.Boat;
import hu.nextval.captainslog.web.backend.common.entities.results.RegattaResult;
import hu.nextval.captainslog.web.backend.logbookserver.boats.BoatService;
import hu.nextval.captainslog.web.backend.logbookserver.metamodell.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@RestController
public class RegattaResultController extends BaseController<RegattaResult, Long, RegattaResultDTO> {

    @Autowired
    protected RegattaResultService regattaResultService;

    @Autowired
    protected BoatService boatService;

    @Override
    @RequestMapping(method = RequestMethod.DELETE, path = "results/regatta/{id}")
    public void delete(@PathVariable("id") Long id) {
        super.delete(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST, path = "results/regatta/")
    public void create(@RequestBody RegattaResultDTO entity) {
        super.create(entity);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "results/regatta/")
    public List<RegattaResultDTO> getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "results/regatta/{id}")
    public RegattaResultDTO getOne(@PathVariable("id") Long id) {
        return super.getOne(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT, path = "results/regatta/{id}")
    public RegattaResultDTO update(Long existingId, @RequestBody RegattaResultDTO updated) {
        return super.update(existingId, updated);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/results/regatta/byboat")
    List<RegattaResultDTO> getAllForBoat(@PathVariable("boatId")long boatId){
        Boat boat = boatService.getOne(boatId);

        if(boat == null) {
            throw new NoSuchBoatException();
        }

        return asDTOList(regattaResultService.getAllByBoat(boat));
    }


    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such boat found!")
    public class NoSuchBoatException extends RuntimeException { }
}
