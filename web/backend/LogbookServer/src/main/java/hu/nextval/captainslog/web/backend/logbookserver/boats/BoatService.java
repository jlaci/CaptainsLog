package hu.nextval.captainslog.web.backend.logbookserver.boats;

import hu.nextval.captainslog.web.backend.common.entities.boats.Boat;
import hu.nextval.captainslog.web.backend.common.entities.users.User;
import hu.nextval.captainslog.web.backend.logbookserver.metamodell.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Service
public class BoatService extends BaseService<Boat, Long> {

    @Autowired
    protected BoatRepository repository;

    public List<Boat> getForUser(User user) {
        return repository.findBySailor(user.getSailor().getId());
    }
}
