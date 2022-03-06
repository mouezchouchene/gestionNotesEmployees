package tn.esprit.spring.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor 
@ToString
public class User {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	 int id;
	String FirstName;
	String Password;
	String email;
	String role;
	String adresse;
	String LastName;
	String civilite;
	int num;
	double moyenne;
	 //relation



	@OneToMany(mappedBy="user")
	 List<Evaluate> Evaluates;


	public User(String firstName, String password, String email, String role, String adresse, String lastName, String civilite, int num, List<Evaluate> evaluates) {
		this.id = id;
		FirstName = firstName;
		Password = password;
		this.email = email;
		this.role = role;
		this.adresse = adresse;
		LastName = lastName;
		this.civilite = civilite;
		this.num = num;
		Evaluates = evaluates;
	}





	//methode moyenne paramétres => list des Evolutions (kolhom) + id user return => moyenne user
	private void moyenne(List<Evaluate> listEvaluations, int id){
		//calcul des notes de mouez
		List<Evaluate> evaluationMouez = listEvaluations.stream()
				.filter(e -> e.getVoteTo() == id).collect(Collectors.toList());


		for (Evaluate e : evaluationMouez){
			moyenne = moyenne + e.getNote();
		}
		System.out.println("La moyenne des votes obtenu  est "+moyenne);
	}


}
