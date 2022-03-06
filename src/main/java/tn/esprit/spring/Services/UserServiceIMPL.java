package tn.esprit.spring.Services;

import tn.esprit.spring.Entities.Evaluate;
import tn.esprit.spring.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.UserRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceIMPL implements UserService{

    @Autowired
    UserRepository userRepository;



    @Override
    public List<User> Users() {
        List<User> users = userRepository.findAll();

        Comparator<User> cmp = Comparator.comparing(User::getMoyenne).reversed();
         users.sort(cmp);

         return users;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(int id) {

        return userRepository.findById(id).get();
    }


    @Override
    public double moyenne(List<Evaluate> listEvaluations, int id){
         double moyenne = 0;
        User user = findUserById(id);
        //calcul des notes de mouez
        List<Evaluate> evaluationMouez = listEvaluations.stream()
                .filter(e -> e.getVoteTo() == id).collect(Collectors.toList());


        for (Evaluate e : evaluationMouez){
            moyenne = moyenne + e.getNote();
        }

        user.setMoyenne(moyenne);
        userRepository.save(user);

        return user.getMoyenne();
    }


}
