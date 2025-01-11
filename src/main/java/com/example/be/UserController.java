package com.example.be;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/*TODO add a env file*/
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName() );
    private final Map<Integer, User> userDatabase = new HashMap<>();
    private int currentId = 1;

    @PostMapping("/add")
    public User createUser(@RequestBody User user) {
        try {
            userDatabase.put(currentId, user);
            currentId++;
            System.out.println("NEW USER ID: " + currentId);
            LOGGER.log( Level.FINE, String.format("Created user with id %d", currentId)  );
            return user;
        } catch (Exception e) {
            LOGGER.log( Level.FINE, e.getMessage()  );
        }
        return null;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userDatabase.get(id);
    }

    @GetMapping("/getAll")
    public Collection<User> getAllUsers() {
        return userDatabase.values();
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        if (userDatabase.containsKey(id)) {
            userDatabase.put(id, user);
            return user;
        } else {
            throw new NoSuchElementException("User not found");
        }
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        if (userDatabase.containsKey(id)) {
            userDatabase.remove(id);
            return "User removed successfully";
        } else {
            throw new NoSuchElementException("User not found");
        }
    }
}