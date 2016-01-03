package hu.nextval.captainslog.web.backend.common.entities.users;

import hu.nextval.captainslog.web.backend.common.entities.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Entity
@Getter
@Setter
public class UserRole implements BaseEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    protected String name;

}
