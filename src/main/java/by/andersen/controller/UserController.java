package by.andersen.controller;

import by.andersen.beans.User;
import by.andersen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /*---Add new book---*/
    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        int id = userService.saveUser(user);
        return ResponseEntity.ok().body("New User has been saved with ID:" + id);
    }

    /*---Get a user by id---*/
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id){
        User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    /*---get all books---*/
    @GetMapping("/userList")
    public ResponseEntity<List<User>> list(){
        List<User>userList = userService.list();
        return ResponseEntity.ok().body(userList);
    }

    /*---Update a user by id---*/
    @PutMapping("/UserUpdate/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody User user) {
        userService.update(id, user);
        return ResponseEntity.ok().body("User has been updated successfully.");
    }
    /*---Delete a user by id---*/
    @DeleteMapping("/userDelet/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        userService.delete(id);
        return ResponseEntity.ok().body("User has been deleted successfully.");
    }
}