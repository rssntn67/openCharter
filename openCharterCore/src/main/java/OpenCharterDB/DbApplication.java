package OpenCharterDB;

import OpenCharterDB.model.Info;
import OpenCharterDB.model.Nave;
import OpenCharterDB.repository.InfoRepository;
import OpenCharterDB.repository.NaveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.ZoneId;

@SpringBootApplication
public class DbApplication {
    //connessione
    public static void main(String... args) {
        SpringApplication.run(DbApplication.class, args);
    }


    private static final Logger log = LoggerFactory.getLogger(DbApplication.class);

    @Bean
    CommandLineRunner initDatabase(NaveRepository repositorynave, InfoRepository repositoryinfo) {

        return args -> {
            log.info("Preloading " + repositorynave.save(new Nave("Costa", "Crociera", "Italia", "Napoli", "Michele Bottiglieri", "Michele Bottiglieri", 20, 50, 3)));
            log.info("Preloading " + repositorynave.save(new Nave("Francofono", "Peschereccio","Spagna", "Barcellona", "Nuno Mendes", "Fabrizio Corona", 15, 7, 39)));


            log.info("Preloading " + repositoryinfo.save(new Info(13,14, 1,LocalDateTime.now(ZoneId.of("Europe/Paris")))));
            log.info("Preloading " + repositoryinfo.save(new Info(27,33, 2,LocalDateTime.now(ZoneId.of("Europe/Paris")))));

        };
    }
}