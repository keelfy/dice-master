package keelfy.dice_master.controller;

import keelfy.dice_master.model.Race;
import keelfy.dice_master.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author keelfy
 */
@Controller
public class RaceController {

    private RaceService raceService;

    @Autowired(required = true)
    @Qualifier(value = "raceService")
    public void setRaceService(RaceService raceService) {
        this.raceService = raceService;
    }

    @RequestMapping(value = "races", method = RequestMethod.GET)
    public String listRaces(Model model) {
        model.addAttribute("race", new Race());
        model.addAttribute("listRaces", this.raceService.listRaces());
        return "races";
    }

    @RequestMapping(value = "/races/add", method = RequestMethod.POST)
    public String addRace(@ModelAttribute("race") Race race) {
        if (race.getId() == 0) {
            this.raceService.addRace(race);
        } else {
            this.raceService.updateRace(race);
        }
        return "redirect:/races";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeRace(@PathVariable("id") int id) {
        this.raceService.removeRace(id);
        return "redirect:/races";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editRace(@PathVariable("id") int id, Model model) {
        model.addAttribute("race", this.raceService.getRace(id));
        model.addAttribute("listRaces", this.raceService.listRaces());
        return "races";
    }

    @RequestMapping(value = "raceData/{id}")
    public String raceData(@PathVariable("id") int id, Model model) {
        model.addAttribute("race", this.raceService.getRace(id));
        return "raceData";
    }
}
