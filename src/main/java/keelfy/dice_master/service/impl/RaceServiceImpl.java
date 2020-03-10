package keelfy.dice_master.service.impl;

import keelfy.dice_master.model.Race;
import keelfy.dice_master.repository.RaceRepository;
import keelfy.dice_master.service.RaceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author keelfy
 */
@Service
public class RaceServiceImpl implements RaceService {

    private RaceRepository raceRepository;

    public void setRaceRepository(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Override
    @Transactional
    public void addRace(Race race) {
        this.raceRepository.addRace(race);
    }

    @Override
    @Transactional
    public void updateRace(Race race) {
        this.raceRepository.updateRace(race);
    }

    @Override
    @Transactional
    public void removeRace(int id) {
        this.raceRepository.removeRace(id);
    }

    @Override
    @Transactional
    public Race getRace(int id) {
        return this.raceRepository.getRace(id);
    }


    @Override
    @Transactional
    public List<Race> listRaces() {
        return this.raceRepository.listRaces();
    }
}
