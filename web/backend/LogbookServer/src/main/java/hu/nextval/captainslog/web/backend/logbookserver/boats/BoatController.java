package hu.nextval.captainslog.web.backend.logbookserver.boats;

import hu.nextval.captainslog.web.backend.common.dto.boats.BoatDTO;
import hu.nextval.captainslog.web.backend.common.entities.boats.Boat;
import hu.nextval.captainslog.web.backend.logbookserver.metamodell.controller.BaseController;
import hu.nextval.captainslog.web.backend.logbookserver.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@RestController
@RequestMapping("/boat")
public class BoatController extends BaseController<Boat, Long, BoatDTO> {

    @Autowired
    protected BoatService service;

    @Autowired
    protected UserService userService;

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody BoatDTO entity) {
        super.create(entity);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public List<BoatDTO> getAll() {
        return super.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/own")
    public List<BoatDTO> getOwn(Principal principal) {
        return asDTOList(service.getForUser(userService.getByPrincipal(principal)));
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public BoatDTO getOne(@PathVariable("id") Long id) {
        return super.getOne(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public BoatDTO update(@PathVariable("id") Long existingId, @RequestBody BoatDTO updated) {
        return super.update(existingId, updated);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        super.delete(id);
    }
}
