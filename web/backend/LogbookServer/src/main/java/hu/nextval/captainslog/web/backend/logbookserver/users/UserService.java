package hu.nextval.captainslog.web.backend.logbookserver.users;

import hu.nextval.captainslog.web.backend.common.entities.users.User;
import hu.nextval.captainslog.web.backend.logbookserver.metamodell.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Service
public class UserService extends BaseService<User,Long> {

    @Autowired
    protected UserRepository repository;

    public User getByPrincipal(Principal principal) {
        String name = principal.getName();

        //Mock the admin TODO: Remove when done debugging
        if("admin".equals(name)) {
            User user = new User();

            user.setId(0l);
            user.setUsername("admin");
            user.setEmail("admin@innosys.hu");

            return user;
        }

        return repository.findByUsername(name);
    }
}
