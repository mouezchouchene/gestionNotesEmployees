package tn.esprit.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entities.Evaluate;
import tn.esprit.spring.Entities.User;
import tn.esprit.spring.Services.EvaluateService;
import tn.esprit.spring.repository.EvaluateRepository;

import java.util.List;

@RestController
public class EvaluateController {

    @Autowired
    EvaluateService evaluateService;

    @GetMapping("Evaluate")
    public List<Evaluate> getAllEvaluation(){
        return evaluateService.Getallvote();
    }

    @PostMapping("user/{id}/Evaluate/")
    public Evaluate addEvaluation(@RequestBody Evaluate evaluate, @PathVariable int id){

        return evaluateService.addvote(id,evaluate);
    }

    @GetMapping("Evaluate/populateData")
    public void populateData(){

        evaluateService.populateData();
    }
}
