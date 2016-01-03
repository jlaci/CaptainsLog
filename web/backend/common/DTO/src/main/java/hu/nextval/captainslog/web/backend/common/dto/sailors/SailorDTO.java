package hu.nextval.captainslog.web.backend.common.dto.sailors;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Getter
@Setter
public class SailorDTO {

    private Long id;

    protected String firstName;

    protected String lastName;

    protected Long userId;

}