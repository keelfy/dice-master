package keelfy.dice_master.controller;

import keelfy.dice_master.model.character.race.Race;
import keelfy.dice_master.repository.GameSourceRepository;
import keelfy.dice_master.repository.RaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controls list of races and specific race details.
 *
 * @author keelfy
 */
@RequiredArgsConstructor
@Controller
@RequestMapping({ "races", "race" })
public class RaceController {

    static final String TEMPLATE_DIRECTORY = "races";

    private final GameSourceRepository gameSourceRepository;
    private final RaceRepository raceRepository;

    @GetMapping({"", "list"})
    private String list(Model model) {
        model.addAttribute("gameSources", gameSourceRepository.findAll());
        return TEMPLATE_DIRECTORY + "/races";
    }

    @GetMapping("{race}")
    private String details(@PathVariable("race") String raceName, Model model) {
        final Race race = raceRepository.findByName(raceName);
        if (race == null)
            return "redirect:/races";

        model.addAttribute("race", race);
        return TEMPLATE_DIRECTORY + "/details";
    }
}
