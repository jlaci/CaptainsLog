package hu.nextval.captainslog.web.backend.common.entities.sailor;

import hu.nextval.captainslog.web.backend.common.entities.BaseEntity;
import hu.nextval.captainslog.web.backend.common.entities.boats.Boat;
import hu.nextval.captainslog.web.backend.common.entities.users.User;
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
public class Sailor implements BaseEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private User user;

    @ManyToMany
    protected List<Boat> boats;


}
