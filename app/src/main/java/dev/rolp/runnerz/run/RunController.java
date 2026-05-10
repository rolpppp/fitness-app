package dev.rolp.runnerz.run;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class RunController {

    private final RunRepo runRepo;

    public RunController(RunRepo runRepo){
        this.runRepo = runRepo;
    }

    
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    // GET
    @GetMapping("/runs")
    List<Run> findAll(){
        return this.runRepo.findAll();
    }

    // POST
    @PostMapping("/runs/add")
    void addRun(Run run){
        runRepo.add(run);
    }

    @GetMapping("/runs/{id}")
    Optional<Run> findById(@PathVariable int id){

        Optional<Run> run = this.runRepo.findById(id);

        if (run.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            return run;
        }
    }
}
