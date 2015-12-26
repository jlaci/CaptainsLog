package hu.nextval.captainslog.web.backend.logbookserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import lombok.extern.apachecommons.*;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Janoky Laszlo Viktor <janoky.laszlo@bmeautsoft.hu>
 */
@CommonsLog
@SpringBootApplication
@ComponentScan("hu.nextval.captainslog")
@EntityScan("hu.nextval.captainslog")
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        log.info("Logbook server succesfully started!");
    }
}
