package tn.esprit.spring.Controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entities.Evaluate;
import tn.esprit.spring.Entities.User;
import tn.esprit.spring.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("User")
    public List<User> users(){
        return userService.Users();
    }


    @GetMapping("User/{id}")
    public User findUserById(@PathVariable int id){
        return userService.findUserById(id);
    }

    @PostMapping("User")
    public User adduser(@RequestBody User user){

        return userService.addUser(user);
    }

    @PutMapping ("User/moyenne/{id}")
    public double userMoyenne(@RequestBody List<Evaluate> evaluateList, @PathVariable int id){
        return userService.moyenne(evaluateList,id);
    }


}
