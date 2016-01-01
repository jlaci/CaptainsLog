package hu.nextval.captainslog.web.backend.common.dto.users;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Getter
@Setter
public class UserDTO {

    protected String username;

    protected String email;

    protected Long id;

}
