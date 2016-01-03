package hu.nextval.captainslog.web.backend.logbookserver.configuration;

import hu.nextval.captainslog.web.backend.common.entities.boats.Boat;
import hu.nextval.captainslog.web.backend.common.entities.clubs.Club;
import hu.nextval.captainslog.web.backend.common.entities.ports.Port;
import hu.nextval.captainslog.web.backend.common.entities.regattas.Race;
import hu.nextval.captainslog.web.backend.common.entities.regattas.Regatta;
import hu.nextval.captainslog.web.backend.common.entities.sailor.Sailor;
import hu.nextval.captainslog.web.backend.common.entities.users.User;
import hu.nextval.captainslog.web.backend.common.entities.users.UserRole;
import hu.nextval.captainslog.web.backend.logbookserver.boats.BoatRepository;
import hu.nextval.captainslog.web.backend.logbookserver.clubs.ClubRepository;
import hu.nextval.captainslog.web.backend.logbookserver.ports.PortRepository;
import hu.nextval.captainslog.web.backend.logbookserver.regattas.RegattaRepository;
import hu.nextval.captainslog.web.backend.logbookserver.regattas.races.RaceRepository;
import hu.nextval.captainslog.web.backend.logbookserver.sailors.SailorRepository;
import hu.nextval.captainslog.web.backend.logbookserver.users.UserRepository;
import hu.nextval.captainslog.web.backend.logbookserver.users.roles.UserRoleRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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

    @Autowired
    protected ClubRepository clubRepository;

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected UserRoleRepository userRoleRepository;

    @Autowired
    protected SailorRepository sailorRepository;

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Autowired
    protected PortRepository portRepository;


    protected Club mvsz;

    protected Club the;

    protected Club tvsk;

    protected Port thePort;

    protected UserRole adminRole;

    protected UserRole userRole;


    protected User admin;

    protected Sailor sailor1;

    protected Sailor sailor2;

    @PostConstruct
    public void init() {
        log.info("Initializing default data.");
        injectDefaultRoles();
        injectExampleSailors();
        injectExampleUsers();
        injectExamplePorts();
        injectExampleClubs();
        injectExampleBoats();
        injectExampleRegattas();
    }

    private void injectExamplePorts() {
        thePort = new Port();
        thePort.setName("THE");
        thePort = portRepository.save(thePort);
    }


    private void injectDefaultRoles() {
        adminRole = new UserRole();
        adminRole.setName("ADMIN");

        userRole = new UserRole();
        userRole.setName("USER");

        adminRole = userRoleRepository.save(adminRole);
        userRole = userRoleRepository.save(userRole);
    }

    private void injectExampleSailors() {
        sailor1 = new Sailor("Teszt", "Sailor1");
        sailor2 = new Sailor("Teszt", "Sailor2");

        sailor1 = sailorRepository.save(sailor1);
        sailor2 = sailorRepository.save(sailor2);
    }

    private void injectExampleUsers() {
        User user = new User();
        user.setUsername("admin");
        user.setEmail("admin@captainslog.hu");
        user.setRoles(Arrays.asList(adminRole, userRole));
        user.setPassword(passwordEncoder.encode("password"));

        Sailor sailor = new Sailor();
        sailor.setFirstName("Admin");
        sailor.setLastName("");
        user.setSailor(sailor);

        admin = userRepository.save(user);
    }

    private void injectExampleClubs() {
        mvsz = new Club();
        mvsz.setName("MVSZ");
        mvsz = clubRepository.save(mvsz);

        tvsk = new Club();
        tvsk.setName("TVSK");
        tvsk = clubRepository.save(tvsk);

        the = new Club();
        the.setName("THE");
        the = clubRepository.save(the);
    }

    private void injectExampleBoats() {
        Boat fanatic = new Boat();
        fanatic.setName("Fanatic");
        fanatic.setSailNumber("HUN 826");
        fanatic.setOwner(admin.getSailor());
        fanatic.setClub(the);
        fanatic.setPort(thePort);

        fanatic.setRoster(Arrays.asList(admin.getSailor(), sailor1));
        admin.getSailor().setBoats(Collections.singletonList(fanatic));
        boatRepository.save(fanatic);
        sailorRepository.save(admin.getSailor());


        Boat echo = new Boat();
        echo.setName("Echo");
        echo.setSailNumber("HUN 72");
        echo.setOwner(sailor2);
        echo.setRoster(Collections.singletonList(sailor2));
        sailor2.setBoats(Collections.singletonList(echo));
        boatRepository.save(echo);
        sailorRepository.save(sailor2);

    }


    private void injectExampleRegattas() {
        //Regattas
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        try {
            //Kekeszalag 2015
            Regatta kekszalag15 = new Regatta();
            kekszalag15.setName("Kekszalag 2015");
            kekszalag15.setStartDate(sdf.parse("02/07/2015 09:00"));
            kekszalag15.setEndDate(sdf.parse("04/07/2015 09:00"));
            kekszalag15.setRegattaType(Regatta.RegattaType.TOURING);
            kekszalag15.setOrganizer(mvsz);
            kekszalag15.setLocation("Balaton");
            //kekszalag15 = regattaRepository.save(kekszalag15);

            Race kekszalag15race = new Race();
            kekszalag15race.setStartDate(sdf.parse("02/07/2015 09:00"));
            kekszalag15race.setEndDate(sdf.parse("04/07/2015 09:00"));
            kekszalag15race.setRegatta(kekszalag15);
            kekszalag15race.setRaceType(Race.RaceType.TOURING);
            kekszalag15race.setOrderInRegatta(1);


            kekszalag15.setRaces(Collections.singletonList(kekszalag15race));
            //raceRepository.save(kekszalag15race);
            regattaRepository.save(kekszalag15);

            //Kekeszalag 2014
            Regatta kekszalag14 = new Regatta();
            kekszalag14.setName("Kekszalag 2014");
            kekszalag14.setStartDate(sdf.parse("02/07/2014 09:00"));
            kekszalag14.setEndDate(sdf.parse("04/07/2014 09:00"));
            kekszalag14.setRegattaType(Regatta.RegattaType.TOURING);
            kekszalag14.setOrganizer(mvsz);
            kekszalag14.setLocation("Balaton");

            //kekszalag14 = regattaRepository.save(kekszalag14);

            Race kekszalag14race = new Race();
            kekszalag14race.setStartDate(sdf.parse("02/07/2014 09:00"));
            kekszalag14race.setEndDate(sdf.parse("04/07/2014 09:00"));
            kekszalag14race.setRegatta(kekszalag14);
            kekszalag14race.setRaceType(Race.RaceType.TOURING);
            kekszalag14race.setOrderInRegatta(1);

            kekszalag14.setRaces(Collections.singletonList(kekszalag14race));
            //raceRepository.save(kekszalag14race);
            regattaRepository.save(kekszalag14);

        } catch (ParseException pe) {
            throw new RuntimeException(pe);
        }
    }

}
