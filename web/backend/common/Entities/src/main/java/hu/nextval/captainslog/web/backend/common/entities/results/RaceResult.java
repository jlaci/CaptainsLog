package hu.nextval.captainslog.web.backend.common.entities.results;

import hu.nextval.captainslog.web.backend.common.entities.BaseEntity;
import hu.nextval.captainslog.web.backend.common.entities.regattas.Race;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Entity
@Getter
@Setter
public class RaceResult implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    protected Race race;

    @ManyToOne
    protected RegattaResult regattaResult;

    protected int position;

}
