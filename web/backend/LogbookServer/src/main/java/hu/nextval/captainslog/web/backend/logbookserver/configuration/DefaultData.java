package hu.nextval.captainslog.web.backend.logbookserver.configuration;

import hu.nextval.captainslog.web.backend.common.entities.boats.Boat;
import hu.nextval.captainslog.web.backend.logbookserver.boats.BoatRepository;
import hu.nextval.captainslog.web.backend.logbookserver.results.RegattaResultRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@Configuration
@Profile("InitDefaultData")
@CommonsLog
public class DefaultData {

    @Autowired
    protected BoatRepository boatRepository;

    @Autowired
    protected RegattaResultRepository regattaResultRepository;

    @PostConstruct
    public void init() {
        log.info("Initializing default data.");

        Boat fanatic = new Boat();
        fanatic.setName("Fanatic");

        if(boatRepository.findByName("Fanatic").isEmpty()) {
            fanatic = boatRepository.save(fanatic);
            log.info("Saved boat " + fanatic + " with id: " + fanatic.getId());
        }

    }

}
