package hu.nextval.captainslog.web.backend.logbookserver.configuration;

import hu.nextval.captainslog.web.backend.common.entities.boats.Boat;
import hu.nextval.captainslog.web.backend.common.entities.regattas.Race;
import hu.nextval.captainslog.web.backend.common.entities.regattas.Regatta;
import hu.nextval.captainslog.web.backend.logbookserver.boats.BoatRepository;
import hu.nextval.captainslog.web.backend.logbookserver.regattas.RegattaRepository;
import hu.nextval.captainslog.web.backend.logbookserver.regattas.races.RaceRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;

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
    protected RegattaRepository regattaRepository;

    @Autowired
    protected RaceRepository raceRepository;


    @PostConstruct
    public void init() {
        log.info("Initializing default data.");

        raceRepository.deleteAll();
        regattaRepository.deleteAll();
        boatRepository.deleteAll();
        log.info("Droped previous data.");

        //Boats
        Boat fanatic = new Boat();
        fanatic.setName("Fanatic");
        fanatic = boatRepository.save(fanatic);

        Boat echo = new Boat();
        echo.setName("Echo");
        echo = boatRepository.save(echo);

        //Regattas
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        try {
            //Kekeszalag 2015
            Regatta kekszalag15 = new Regatta();
            kekszalag15.setName("Kekszalag 2015");
            kekszalag15.setStartDate(sdf.parse("02/07/2015 09:00"));
            kekszalag15.setEndDate(sdf.parse("04/07/2015 09:00"));
            kekszalag15.setRegattaType(Regatta.RegattaType.TOURING);
            kekszalag15 = regattaRepository.save(kekszalag15);

            Race kekszalag15race = new Race();
            kekszalag15race.setStartDate(sdf.parse("02/07/2015 09:00"));
            kekszalag15race.setEndDate(sdf.parse("04/07/2015 09:00"));
            kekszalag15race.setRegatta(kekszalag15);
            kekszalag15race.setRaceType(Race.RaceType.TOURING);
            kekszalag15race = raceRepository.save(kekszalag15race);

            kekszalag15.setRaces(Collections.singletonList(kekszalag15race));
            regattaRepository.save(kekszalag15);

            //Kekeszalag 2014
            Regatta kekszalag14 = new Regatta();
            kekszalag14.setName("Kekszalag 2014");
            kekszalag14.setStartDate(sdf.parse("02/07/2014 09:00"));
            kekszalag14.setEndDate(sdf.parse("04/07/2014 09:00"));
            kekszalag14.setRegattaType(Regatta.RegattaType.TOURING);
            kekszalag14 = regattaRepository.save(kekszalag14);

            Race kekszalag14race = new Race();
            kekszalag14race.setStartDate(sdf.parse("02/07/2014 09:00"));
            kekszalag14race.setEndDate(sdf.parse("04/07/2014 09:00"));
            kekszalag14race.setRegatta(kekszalag14);
            kekszalag14race.setRaceType(Race.RaceType.TOURING);
            kekszalag14race = raceRepository.save(kekszalag14race);

            kekszalag14.setRaces(Collections.singletonList(kekszalag14race));
            regattaRepository.save(kekszalag14);

        } catch (ParseException pe) {
            throw new RuntimeException(pe);
        }

    }

}
