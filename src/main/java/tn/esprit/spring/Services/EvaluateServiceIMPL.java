package tn.esprit.spring.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import tn.esprit.spring.Entities.Evaluate;
import tn.esprit.spring.Entities.User;
import tn.esprit.spring.repository.EvaluateRepository;

@Service
public class EvaluateServiceIMPL implements EvaluateService {
	@Autowired
	EvaluateRepository evaluaterepo;
	@Autowired
	UserService userService;

	@Override
	public void populateData() {

		User mouez = new User("mouez", "Password", "email", "role", "adresse", "LastName", "civilite", 21614264, null);
		User wejden = new User("wejden", "Password", "email", "role", "adresse", "LastName", "civilite", 21614264, null);
		User siwar = new User("siwar", "Password", "email", "role", "adresse", "LastName", "civilite", 21614264, null);

		userService.addUser(mouez);
		userService.addUser(wejden);
		userService.addUser(siwar);

		Evaluate mouezToWejden = new Evaluate(1, 18.5, "Exellent", wejden.getId(), mouez.getId(), mouez);
		Evaluate mouezToSiwar = new Evaluate(2, 10.5, "Passable", siwar.getId(), mouez.getId(), mouez);
		List<Evaluate> listMouez = new ArrayList<>();
		listMouez.add(mouezToWejden);
		listMouez.add(mouezToSiwar);
		Evaluate wejdenToMouez = new Evaluate(3, 20, "Exellent", mouez.getId(), wejden.getId(), wejden);
		Evaluate wejdenToSiwar = new Evaluate(4, 10.5, "Passable", siwar.getId(), wejden.getId(), wejden);
		List<Evaluate> listWejden = new ArrayList<>();
		listWejden.add(wejdenToMouez);
		listWejden.add(wejdenToSiwar);
		Evaluate siwarToMouez = new Evaluate(5, 15, "Exellent", mouez.getId(), siwar.getId(), siwar);
		Evaluate siwarToWejeden = new Evaluate(6, 10.5, "Passable", wejden.getId(), siwar.getId(), siwar);
		List<Evaluate> listSiwar = new ArrayList<>();
		listSiwar.add(siwarToMouez);
		listSiwar.add(siwarToWejeden);

		List<Evaluate> listEvaluations = new ArrayList<>();
		listEvaluations.addAll(listSiwar);
		listEvaluations.addAll(listWejden);
		listEvaluations.addAll(listMouez);
		evaluaterepo.saveAll(listEvaluations);


	}

	@Override
	public List<Evaluate> Getallvote() {
		return evaluaterepo.findAll();
	}

	@Override
	public Evaluate addvote(int id, Evaluate note) {
		User user = userService.findUserById(id);
		note.setUser(user);
		return evaluaterepo.save(note);

	}


}



