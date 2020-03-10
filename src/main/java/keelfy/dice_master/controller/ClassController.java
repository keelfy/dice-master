package keelfy.dice_master.controller;

import keelfy.dice_master.model.CharacterClass;
import keelfy.dice_master.service.ClassService;
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
public class ClassController {

    private ClassService classService;

    @Autowired(required = true)
    @Qualifier(value = "classService")
    public void setClassService(ClassService classService) {
        this.classService = classService;
    }

    @RequestMapping(value = "classes", method = RequestMethod.GET)
    public String listClasses(Model model) {
        model.addAttribute("clazz", new CharacterClass());
        model.addAttribute("listClasses", this.classService.listClasses());
        return "classes";
    }

    @RequestMapping(value = "/classes/add", method = RequestMethod.POST)
    public String addClass(@ModelAttribute("class") CharacterClass characterClass) {
        if (characterClass.getId() == 0) {
            this.classService.addClass(characterClass);
        } else {
            this.classService.updateClass(characterClass);
        }
        return "redirect:/classes";
    }

    @RequestMapping(value = "/classes/remove/{id}")
    public String removeClass(@PathVariable("id") int id) {
        this.classService.removeClass(id);
        return "redirect:/classes";
    }

    @RequestMapping(value = "/classes/edit/{id}")
    public String editClass(@PathVariable("id") int id, Model model) {
        model.addAttribute("clazz", this.classService.getClass(id));
        model.addAttribute("listClasses", this.classService.listClasses());
        return "classes";
    }

    @RequestMapping(value = "/classInfo/{id}")
    public String classInfo(@PathVariable("id") int id, Model model) {
        model.addAttribute("clazz", this.classService.getClass(id));
        return "classInfo";
    }
}
