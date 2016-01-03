package hu.nextval.captainslog.web.backend.logbookserver.users.roles;

import hu.nextval.captainslog.web.backend.common.entities.users.UserRole;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

}
