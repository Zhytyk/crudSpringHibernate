package app.library;

import app.Repository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 17-Jun-17.
 */

@Service("libraryService")
public class LibraryServiceImpl implements app.Service<Library> {
    private Repository<Library> libraryRepository;

    @Autowired
    public void setLibraryRepository(Repository<Library> libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public Library findById(int id) {
        return libraryRepository.getById(id);
    }

    @Override
    public List<Library> findAllById(Integer id) {
        return libraryRepository.getAllById(id);
    }

    @Override
    public void save(Library library) {
        libraryRepository.save(library);
    }

    @Override
    public void delete(Library library) {
        libraryRepository.delete(library);
    }

}
