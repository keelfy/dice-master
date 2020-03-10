package keelfy.dice_master.service;

import keelfy.dice_master.model.Race;

import java.util.List;

/**
 * @author keelfy
 */
public interface RaceService {

    public void addRace(Race race);

    public void updateRace(Race race);

    public void removeRace(int id);

    public Race getRace(int id);

    public List<Race> listRaces();
}
