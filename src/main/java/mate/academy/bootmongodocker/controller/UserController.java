package mate.academy.bootmongodocker.controller;

import java.util.Optional;
import mate.academy.bootmongodocker.model.User;
import mate.academy.bootmongodocker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Iterable<User> get() {
        return userRepository.findAll();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public Optional<User> read(@PathVariable String id) {
        return userRepository.findById(id);
    }

    @GetMapping("/inject")
    public void inject() {
        User bob = new User();
        bob.setName("Bob");
        User alice = new User();
        alice.setName("Alice");
        userRepository.save(bob);
        userRepository.save(alice);
    }
}
