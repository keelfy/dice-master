package keelfy.dice_master.controller;

import keelfy.dice_master.model.world.SpeakingLanguage;
import keelfy.dice_master.repository.SpeakingLanguageRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author keelfy
 */
@Controller
@RequestMapping("/options")
@PreAuthorize("hasAuthority('ADMIN')")
public class WorldController {

    private final SpeakingLanguageRepository speakingLanguageRepository;

    public WorldController(SpeakingLanguageRepository speakingLanguageRepository) {
        this.speakingLanguageRepository = speakingLanguageRepository;
    }

    @GetMapping("/")
    public String index(Map<String, Object> model) {
        Iterable<SpeakingLanguage> languages = speakingLanguageRepository.findAll();
        model.put("language", languages);
        return "world_options";
    }

    @PostMapping("/speaking-language/add")
    public String addLanguage(@RequestBody SpeakingLanguage language) {
        speakingLanguageRepository.save(language);
        return "world_options";
    }
}
