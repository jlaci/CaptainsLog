package hu.nextval.captainslog.web.backend.logbookserver.users;

import hu.nextval.captainslog.web.backend.common.entities.users.User;
import hu.nextval.captainslog.web.backend.common.entities.users.UserRole;
import hu.nextval.captainslog.web.backend.logbookserver.metamodell.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Service
public class UserService extends BaseService<User,Long> implements UserDetailsService {

    @Autowired
    protected UserRepository repository;

    public User getByPrincipal(Principal principal) {
        String name = principal.getName();
        return repository.findByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database ");
        }

        return convertToSpringUser(user);
    }

    /**
     * Converts a domain user to Spring Security specific user.
     *
     * @param user
     * @return
     */
    protected UserDetails convertToSpringUser(User user) {
        List<GrantedAuthority> roles = new ArrayList<>();

        for(UserRole role : user.getRoles()){
            roles.add(convertRoleToSpringAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
    }

    /**
     * Converts the user roles to Spring managed authorities.
     *
     * @param role
     * @return
     */
    private GrantedAuthority convertRoleToSpringAuthority(String role) {
        return new SimpleGrantedAuthority(role);
    }
}
