package hu.nextval.captainslog.web.backend.logbookserver.clubs;

import hu.nextval.captainslog.web.backend.common.dto.clubs.ClubDTO;
import hu.nextval.captainslog.web.backend.common.entities.clubs.Club;
import hu.nextval.captainslog.web.backend.logbookserver.metamodell.controller.BaseController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@RestController
@RequestMapping(path = "/club")
public class ClubController extends BaseController<Club, Long, ClubDTO> {

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public List<ClubDTO> getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ClubDTO getOne(@PathVariable("id") Long id) {
        return super.getOne(id);
    }

}