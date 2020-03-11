package keelfy.dice_master.controller;

import keelfy.dice_master.model.Race;
import keelfy.dice_master.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author keelfy
 */
@Controller
@RequestMapping("/races")
public class RaceController {

    private RaceService raceService;

    @Autowired
    @Qualifier("raceService")
    public void setRaceService(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping(value = {"/", "", "list"})
    public String listRaces(Model model) {
        model.addAttribute("race", new Race());
        model.addAttribute("listRaces", this.raceService.listRaces());
        return "races";
    }

    @PostMapping(value = "/add")
    public String addRace(@ModelAttribute("race") Race race) {
        if (race.getId() == 0) {
            this.raceService.addRace(race);
        } else {
            this.raceService.updateRace(race);
        }
        return "redirect:/races";
    }

    @GetMapping(value = "/remove/{id}")
    public String removeRace(@PathVariable("id") int id) {
        this.raceService.removeRace(id);
        return "redirect:/races";
    }

    @GetMapping(value = "/edit/{id}")
    public String editRace(@PathVariable("id") int id, Model model) {
        model.addAttribute("race", this.raceService.getRace(id));
        model.addAttribute("listRaces", this.raceService.listRaces());
        return "races";
    }

    @GetMapping(value = "/info/{id}")
    public String raceData(@PathVariable("id") int id, Model model) {
        model.addAttribute("race", this.raceService.getRace(id));
        return "/races/info";
    }
}
