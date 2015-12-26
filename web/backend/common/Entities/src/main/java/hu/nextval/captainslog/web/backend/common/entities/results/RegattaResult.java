package hu.nextval.captainslog.web.backend.common.entities.results;

import hu.nextval.captainslog.web.backend.common.entities.boats.Boat;
import hu.nextval.captainslog.web.backend.common.entities.regattas.Regatta;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * One regatta result for one boat.
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Getter
@Setter
@Entity
public class RegattaResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    protected Regatta regatta;

    @OneToMany(mappedBy = "regattaResult")
    protected List<RaceResult> raceResults;

    @ManyToOne
    protected Boat boat;
}
