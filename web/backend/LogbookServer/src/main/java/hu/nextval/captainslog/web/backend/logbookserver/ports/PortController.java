package hu.nextval.captainslog.web.backend.logbookserver.ports;

import hu.nextval.captainslog.web.backend.common.dto.ports.PortDTO;
import hu.nextval.captainslog.web.backend.common.entities.ports.Port;
import hu.nextval.captainslog.web.backend.logbookserver.metamodell.controller.BaseController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@RestController
@RequestMapping(path = "/port")
public class PortController extends BaseController<Port, Long, PortDTO> {

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public List<PortDTO> getAll() {
        return super.getAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public PortDTO getOne(@PathVariable("id") Long id) {
        return super.getOne(id);
    }

}