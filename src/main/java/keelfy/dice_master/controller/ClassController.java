package keelfy.dice_master.controller;

import keelfy.dice_master.model.CharacterClass;
import keelfy.dice_master.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author keelfy
 */
@Controller
@RequestMapping("/classes")
public class ClassController {

    private ClassService classService;

    @Autowired(required = true)
    @Qualifier(value = "classService")
    public void setClassService(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping(value = {"/", "", "list"})
    public String listClasses(Model model) {
        model.addAttribute("clazz", new CharacterClass());
        model.addAttribute("listClasses", this.classService.listClasses());
        return "classes";
    }

    @PostMapping("/add")
    public String addClass(@ModelAttribute("class") CharacterClass characterClass) {
        if (characterClass.getId() == 0) {
            this.classService.addClass(characterClass);
        } else {
            this.classService.updateClass(characterClass);
        }
        return "redirect:/classes";
    }

    @GetMapping(value = "/remove/{id}")
    public String removeClass(@PathVariable("id") int id) {
        this.classService.removeClass(id);
        return "redirect:/classes";
    }

    @GetMapping(value = "/edit/{id}")
    public String editClass(@PathVariable("id") int id, Model model) {
        model.addAttribute("clazz", this.classService.getClass(id));
        model.addAttribute("listClasses", this.classService.listClasses());
        return "classes";
    }

    @GetMapping(value = "/info/{id}")
    public String classInfo(@PathVariable("id") int id, Model model) {
        model.addAttribute("clazz", this.classService.getClass(id));
        return "/classes/info";
    }
}
