package dev.rolp.runnerz.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepo {

    private List<Run> runs = new ArrayList<>();

    // GET

    List<Run> findAll(){
        return runs;
    }

    Optional<Run> findById(int id){
        return runs.stream()
            .filter(run -> run.id() == id)
            .findFirst();
    }

    // POST
    void add(Run run){
        runs.add(run);
    }

    // 

    
    @PostConstruct
    private void init() {
        runs.add(new Run(
                1,
                "Morning Jog",
                LocalDateTime.now().minusDays(10),
                LocalDateTime.now().minusDays(10).plus(45, ChronoUnit.MINUTES),
                5.2,
                "Tacloban City"
        ));
        runs.add(new Run(
                2,
                "Evening Run",
                LocalDateTime.now().minusDays(8),
                LocalDateTime.now().minusDays(8).plus(1, ChronoUnit.HOURS),
                8.5,
                "Hilongos"
        ));
        runs.add(new Run(
                3,
                "Beachside Sprint",
                LocalDateTime.now().minusDays(6),
                LocalDateTime.now().minusDays(6).plus(30, ChronoUnit.MINUTES),
                3.0,
                "Palo"
        ));
        runs.add(new Run(
                4,
                "Long Distance Training",
                LocalDateTime.now().minusDays(4),
                LocalDateTime.now().minusDays(4).plus(2, ChronoUnit.HOURS),
                18.7,
                "Ormoc"
        ));
        runs.add(new Run(
                5,
                "Sunday Recovery Run",
                LocalDateTime.now().minusDays(2),
                LocalDateTime.now().minusDays(2).plus(50, ChronoUnit.MINUTES),
                6.4,
                "Baybay"
        ));

    }
}
