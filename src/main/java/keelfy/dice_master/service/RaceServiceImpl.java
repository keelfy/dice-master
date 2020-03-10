package keelfy.dice_master.service;

import keelfy.dice_master.model.Race;
import keelfy.dice_master.repository.RaceDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author keelfy
 */
@Service
public class RaceServiceImpl implements RaceService {

    private RaceDao raceDao;

    public void setRaceDao(RaceDao raceDao) {
        this.raceDao = raceDao;
    }

    @Override
    @Transactional
    public void addRace(Race race) {
        this.raceDao.addRace(race);
    }

    @Override
    @Transactional
    public void updateRace(Race race) {
        this.raceDao.updateRace(race);
    }

    @Override
    @Transactional
    public void removeRace(int id) {
        this.raceDao.removeRace(id);
    }

    @Override
    @Transactional
    public Race getRace(int id) {
        return this.raceDao.getRace(id);
    }


    @Override
    @Transactional
    public List<Race> listRaces() {
        return this.raceDao.listRaces();
    }
}
