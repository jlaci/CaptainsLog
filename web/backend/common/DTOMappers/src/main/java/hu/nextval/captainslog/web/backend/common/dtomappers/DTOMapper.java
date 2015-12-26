package hu.nextval.captainslog.web.backend.common.dtomappers;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
public interface DTOMapper <FromType, ToType> {

    ToType mapTo(FromType entity);

    FromType mapFrom(ToType dto);
}
