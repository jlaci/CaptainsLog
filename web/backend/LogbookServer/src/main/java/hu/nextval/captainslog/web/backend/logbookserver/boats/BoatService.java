package hu.nextval.captainslog.web.backend.logbookserver.boats;

import com.google.common.collect.Lists;
import hu.nextval.captainslog.web.backend.common.entities.boats.Boat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Service
public class BoatService {

    @Autowired
    protected BoatRepository boatRepository;

    public Boat getOne(long id) {
        return boatRepository.findOne(id);
    }

    public List<Boat> getAll() {
        return Lists.newArrayList(boatRepository.findAll());
    }
}
