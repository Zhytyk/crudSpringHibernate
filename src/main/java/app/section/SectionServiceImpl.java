package app.section;

import app.Repository;
import app.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 * Created by Pavel on 18-Jun-17.
 */

@org.springframework.stereotype.Service("sectionService")
public class SectionServiceImpl implements Service<Section> {
    private Repository<Section> sectionRepository;

    public Repository<Section> getSectionRepository() {
        return sectionRepository;
    }

    @Autowired
    public void setSectionRepository(Repository<Section> sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public Section findById(int id) {
        return sectionRepository.getById(id);
    }

    @Override
    public List<Section> findAllById(Integer id) {
        return sectionRepository.getAllById(id);
    }

    @Override
    public void save(Section section) {
        sectionRepository.save(section);
    }

    @Override
    public void delete(Section section) {
        sectionRepository.delete(section);
    }
}
