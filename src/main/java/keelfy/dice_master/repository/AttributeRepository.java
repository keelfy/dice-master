package keelfy.dice_master.repository;

import java.util.List;
import keelfy.dice_master.model.Attribute;

/**
 * @author keelfy
 */
public interface AttributeRepository {

    public void addAttribute(Attribute attribute);

    public void updateAttribute(Attribute attribute);

    public void removeAttribute(int id);

    public Attribute getAttribute(int id);

    public List<Attribute> listAttributes();

}
