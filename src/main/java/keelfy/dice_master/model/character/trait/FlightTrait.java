package keelfy.dice_master.model.character.trait;

import keelfy.dice_master.model.character.GameCharacter;
import keelfy.dice_master.model.character.Trait;

/**
 * @author keelfy
 */
public class FlightTrait extends Trait {

    @Override
    public void process(GameCharacter character) {
        // if character doesn't have any medium or heavy armor
        // then his speed ups to 50 ft.
    }
}
