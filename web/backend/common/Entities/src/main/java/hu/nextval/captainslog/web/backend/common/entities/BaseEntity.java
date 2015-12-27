package hu.nextval.captainslog.web.backend.common.entities;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
public interface BaseEntity<IDType> {
    IDType getId();

    void setId(IDType id);
}
