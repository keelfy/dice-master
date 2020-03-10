package keelfy.dice_master.repository;

import java.util.List;

import keelfy.dice_master.model.Race;

/**
 * @author keelfy
 */
public interface RaceDao {

    public void addRace(Race race);

    public void updateRace(Race race);

    public void removeRace(int id);

    public Race getRace(int id);

    public List<Race> listRaces();
}
