package hu.nextval.captainslog.web.backend.common.entities.boats;

import hu.nextval.captainslog.web.backend.common.entities.results.RegattaResult;
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
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    protected String name;

    @OneToMany(mappedBy = "boat")
    protected List<RegattaResult> regattaResults;

    @Override
    public String toString() {
        return name;
    }
}
