package hu.nextval.captainslog.web.backend.common.entities.regattas;

import hu.nextval.captainslog.web.backend.common.entities.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Getter
@Setter
@Entity
public class Race implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    protected Regatta regatta;

    protected Date startDate;

    protected Date endDate;
}
