package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.Entities.Evaluate;

public interface EvaluateService {

    List<Evaluate> Getallvote();
    Evaluate addvote(int id, Evaluate note);
     void populateData();

}
