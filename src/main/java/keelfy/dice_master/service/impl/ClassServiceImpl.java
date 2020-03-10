package keelfy.dice_master.service.impl;

import keelfy.dice_master.model.CharacterClass;
import keelfy.dice_master.repository.ClassRepository;
import keelfy.dice_master.service.ClassService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author keelfy
 */
public class ClassServiceImpl implements ClassService {

    private ClassRepository classRepository;

    public void setClassRepository(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    @Transactional
    public void addClass(CharacterClass characterClass) {
        this.classRepository.addClass(characterClass);
    }

    @Override
    @Transactional
    public void updateClass(CharacterClass characterClass) {
        this.classRepository.updateClass(characterClass);
    }

    @Override
    @Transactional
    public void removeClass(int id) {
        this.classRepository.removeClass(id);
    }

    @Override
    @Transactional
    public CharacterClass getClass(int id) {
        return this.classRepository.getClass(id);
    }

    @Override
    @Transactional
    public List<CharacterClass> listClasses() {
        return this.classRepository.listClasses();
    }
}
