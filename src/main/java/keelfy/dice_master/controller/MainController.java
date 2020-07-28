package keelfy.dice_master.controller;

import keelfy.dice_master.model.Visit;
import keelfy.dice_master.model.user.User;
import keelfy.dice_master.repository.VisitRepository;
import org.joda.time.DateTime;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @author keelfy
 */
@Controller
public class MainController {

    private final VisitRepository visitRepository;

    public MainController(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @GetMapping
    public String index(Map<String, Object> model) {
        Visit visit = new Visit();
        visit.setTime(DateTime.now());
        visitRepository.save(visit);
        return "index";
    }

    @GetMapping("/main")
    public String index(@AuthenticationPrincipal User user, Map<String, Object> model) {
        model.put("title", "main");
        model.put("name", user.getUsername());
        Iterable<Visit> visits = visitRepository.findAll();
        model.put("visits", visits);
        return "main";
    }
}
