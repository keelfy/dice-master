package keelfy.dice_master.controller;

import keelfy.dice_master.model.character.*;
import keelfy.dice_master.model.user.User;
import keelfy.dice_master.repository.CharacterClassRepository;
import keelfy.dice_master.repository.CharacterRepository;
import keelfy.dice_master.repository.GameSourceRepository;
import keelfy.dice_master.repository.RaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @author keelfy
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("characters/builder/")
@PreAuthorize("hasAuthority('ADMIN')")
@SessionAttributes(types = GameCharacter.class)
@Log4j2
public class CharacterCreationController {

    private final CharacterRepository characterRepository;
    private final GameSourceRepository gameSourceRepository;
    private final RaceRepository raceRepository;
    private final CharacterClassRepository characterClassRepository;

    @GetMapping
    public String index() {
        return "redirect:/main";
    }

    @GetMapping("{step}")
    public String basics(
            @AuthenticationPrincipal User user,
            Model model,
            @PathVariable("step") String stepName
    ) {
        CharacterBuilderStep step;
        try {
            step = CharacterBuilderStep.valueOf(stepName.toUpperCase());
        } catch (IllegalArgumentException e) {
            log.warn("Incorrect step '" + stepName + "' received. Redirecting to main page...");
            return "redirect:/main";
        }

        if (!model.containsAttribute("gameCharacter")) {
            log.info("'gameCharacter' attribute not found. Creating new one...");
            GameCharacter gameCharacter = new GameCharacter();
            gameCharacter.setName(user.getUsername() + "'s character");
            model.addAttribute("gameCharacter", gameCharacter);
            log.info("Created new 'gameCharacter' attribute with name '" + gameCharacter.getName() + "'");
        }

        switch (step) {
            case BASICS:
                processBasicsPage(model);
                break;
            case RACE:
                processRacePage(model);
                break;
            case CHARACTERCLASS:
                processClassPage(model);
                break;
            case ABILITIES:
                processAbilitiesPage(model);
                break;
            case STORY:
                processStoryPage(model);
                break;
            case EQUIPMENT:
                processEquipmentPage(model);
                break;
        }

        return ("characters/builder/" + stepName.toLowerCase().replaceAll("_", "-"));
    }

    private void processBasicsPage(Model model) {
        model.addAttribute("gameSources", gameSourceRepository.findAll());
        model.addAttribute("characterProgressionTypes", Arrays.asList(CharacterProgressionType.values()));
        model.addAttribute("hitPointTypes", Arrays.asList(HitPointType.values()));
        model.addAttribute("characterPrivacyTypes", Arrays.asList(CharacterPrivacyType.values()));
    }

    private void processRacePage(Model model) {
        model.addAttribute("gameSources", gameSourceRepository.findAll());
        model.addAttribute("races", raceRepository.findAll());
    }

    private void processClassPage(Model model) {
        model.addAttribute("characterClasses", characterClassRepository.findAll());
    }

    private void processAbilitiesPage(Model model) {

    }

    private void processStoryPage(Model model) {

    }

    private void processEquipmentPage(Model model) {

    }
}
