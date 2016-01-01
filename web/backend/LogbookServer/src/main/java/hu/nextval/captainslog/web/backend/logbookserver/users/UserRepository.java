package hu.nextval.captainslog.web.backend.logbookserver.users;

import hu.nextval.captainslog.web.backend.common.entities.users.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
