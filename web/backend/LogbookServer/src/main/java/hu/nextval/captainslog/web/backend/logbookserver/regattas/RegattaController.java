package hu.nextval.captainslog.web.backend.logbookserver.regattas;

import hu.nextval.captainslog.web.backend.common.dto.regattas.RegattaDTO;
import hu.nextval.captainslog.web.backend.common.entities.regattas.Regatta;
import hu.nextval.captainslog.web.backend.logbookserver.metamodell.controller.BaseController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@RestController
@RequestMapping(path = "/regatta")
public class RegattaController extends BaseController<Regatta, Long, RegattaDTO> {

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody RegattaDTO entity) {
        super.create(entity);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public List<RegattaDTO> getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public RegattaDTO getOne(@PathVariable("id") Long id) {
        return super.getOne(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public RegattaDTO update(@PathVariable("id") Long existingId, @RequestBody RegattaDTO updated) {
        return super.update(existingId, updated);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        super.delete(id);
    }
}
