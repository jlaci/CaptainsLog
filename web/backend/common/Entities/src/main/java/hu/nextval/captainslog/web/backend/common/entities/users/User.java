package hu.nextval.captainslog.web.backend.common.entities.users;

import hu.nextval.captainslog.web.backend.common.entities.BaseEntity;
import hu.nextval.captainslog.web.backend.common.entities.sailor.Sailor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Entity
@Getter
@Setter
public class User implements BaseEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected String username;

    protected String password;

    protected String email;

    @OneToOne(cascade = CascadeType.ALL)
    protected Sailor sailor;

    @ManyToMany(fetch = FetchType.EAGER)
    protected List<UserRole> roles;

}
