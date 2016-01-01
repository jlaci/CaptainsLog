package hu.nextval.captainslog.web.backend.common.entities.regattas;

import hu.nextval.captainslog.web.backend.common.entities.BaseEntity;
import hu.nextval.captainslog.web.backend.common.entities.clubs.Club;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Describes a sailing regatta which may consist of multiple races.
 *
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Entity
@Getter
@Setter
public class Regatta implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected String name;

    protected String location;

    protected RegattaType regattaType;

    protected Date startDate;

    protected Date endDate;

    @ManyToOne
    protected Club organizer;

    @OneToMany(mappedBy = "regatta", cascade = CascadeType.ALL)
    protected List<Race> races;

    public enum RegattaType {
        TOURING,
        COURSE,
        MIXED
    }

}
