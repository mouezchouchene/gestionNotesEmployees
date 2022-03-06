package tn.esprit.spring.Services;


import tn.esprit.spring.Entities.Evaluate;
import tn.esprit.spring.Entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> Users();
    User addUser(User user);
    User findUserById(int id);

    double moyenne (List<Evaluate> listEvaluations, int id);


}
