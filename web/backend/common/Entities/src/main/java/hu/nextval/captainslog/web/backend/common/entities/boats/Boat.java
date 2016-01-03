package hu.nextval.captainslog.web.backend.common.entities.boats;

import hu.nextval.captainslog.web.backend.common.entities.BaseEntity;
import hu.nextval.captainslog.web.backend.common.entities.clubs.Club;
import hu.nextval.captainslog.web.backend.common.entities.ports.Port;
import hu.nextval.captainslog.web.backend.common.entities.results.RegattaResult;
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
public class Boat implements BaseEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected String name;

    protected String sailNumber;

    @ManyToOne
    protected Club club;

    @ManyToOne
    protected Port port;

    @ManyToOne
    protected Sailor owner;

    @OneToMany(mappedBy = "boat")
    protected List<RegattaResult> regattaResults;

    @ManyToMany(mappedBy = "boats")
    protected List<Sailor> roster;

    @Override
    public String toString() {
        return name;
    }
}
