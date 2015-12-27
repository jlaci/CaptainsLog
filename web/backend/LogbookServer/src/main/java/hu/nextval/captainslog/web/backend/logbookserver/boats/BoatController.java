package hu.nextval.captainslog.web.backend.logbookserver.boats;

import hu.nextval.captainslog.web.backend.common.dto.boats.BoatDTO;
import hu.nextval.captainslog.web.backend.common.entities.boats.Boat;
import hu.nextval.captainslog.web.backend.logbookserver.metamodell.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@RestController
public class BoatController extends BaseController<Boat, Long, BoatDTO> {

    @Autowired
    protected BoatService boatService;

    @RequestMapping(method = RequestMethod.GET, path = "/boats/all")
    public List<BoatDTO> getAll() {
        return asDTOList(boatService.getAll());
    }
}
