package keelfy.dice_master.controller;

import keelfy.dice_master.model.user.UserRole;
import keelfy.dice_master.model.user.User;
import keelfy.dice_master.repository.UserRepository;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

/**
 * Controls registration process.
 *
 * @author keelfy
 */
@Controller
public class RegistrationController {

    private final UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(UserRole.USER));
        user.setCreatedAt(DateTime.now());
        userRepository.save(user);
        return "redirect:/login";
    }
}
