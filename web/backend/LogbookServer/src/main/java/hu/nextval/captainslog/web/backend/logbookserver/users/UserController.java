package hu.nextval.captainslog.web.backend.logbookserver.users;

import hu.nextval.captainslog.web.backend.common.dto.users.UserDTO;
import hu.nextval.captainslog.web.backend.common.entities.users.User;
import hu.nextval.captainslog.web.backend.logbookserver.metamodell.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@RestController
public class UserController extends BaseController<User, Long, UserDTO>{

    @Autowired
    protected UserService service;

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping("/user/current")
    public UserDTO getCurrentDetails(Principal user){
        return dtoMapper.mapTo(service.getByPrincipal(user));
    }

}
