package keelfy.dice_master.controller;

import keelfy.dice_master.model.character.CharacterClass;
import keelfy.dice_master.repository.CharacterClassRepository;
import keelfy.dice_master.repository.GameSourceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controls list of character classes and specific class details.
 *
 * @author keelfy
 */
@RequiredArgsConstructor
@Log4j2
@Controller
@RequestMapping({ "characterclass", "characterclasses", "class", "classes" })
public class CharacterClassController {

    static final String TEMPLATE_DIRECTORY = "characters/classes";

    private final GameSourceRepository gameSourceRepository;
    private final CharacterClassRepository characterClassRepository;

    @GetMapping({"", "list"})
    private String list(Model model) {
        model.addAttribute("gameSources", gameSourceRepository.findAll());
        return TEMPLATE_DIRECTORY + "/classes";
    }

    @GetMapping("{character_class}")
    private String details(@PathVariable("character_class") String className, Model model) {
        final CharacterClass characterClass = characterClassRepository.findByName(className);
        if (characterClass == null)
            return "redirect:/classes";

        model.addAttribute("characterClass", characterClass);
        return TEMPLATE_DIRECTORY + "/details";
    }
}
