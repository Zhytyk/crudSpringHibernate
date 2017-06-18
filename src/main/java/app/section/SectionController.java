package app.section;

import app.Service;
import app.library.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Created by Pavel on 18-Jun-17.
 */
@Controller
public class SectionController {
    private Service<Section> sectionService;
    private Service<Library> libraryService;

    @Autowired
    public void setSectionService(Service<Section> sectionService) {
        this.sectionService = sectionService;
    }

    public Service<Section> getSectionService() {
        return sectionService;
    }

    @Autowired
    public void setLibraryService(Service<Library> sectionService) {
        this.libraryService = sectionService;
    }

    public Service<Library> getLibraryService() {
        return libraryService;
    }

    @RequestMapping(value = "/sections/{id}")
    public String index(@PathVariable Integer id, Model uiModel) {
        List<Section> sections = sectionService.findAllById(id);

        uiModel.addAttribute("sections", sections);

        return "section/index";
    }

    @RequestMapping(value = "/sections/add/{id}", method = RequestMethod.GET)
    public String add(@PathVariable Integer id, Model uiModel) {
        uiModel.addAttribute("id", id);
        return "section/add";
    }

    @RequestMapping(value = "/sections/add", method = RequestMethod.POST)
    public String add(@RequestParam Integer library_id, Section section) {
        section.setLibrary(libraryService.findById(library_id));
        section.setDate(new Date());

        sectionService.save(section);
        return "redirect:/sections/" + library_id;
    }

    @RequestMapping(value="/sections/delete", method = RequestMethod.POST)
    public String delete(@RequestParam Integer id) {
        Section foundSection = sectionService.findById(id);

        int library_id = foundSection.getLibrary().getId();

        sectionService.delete(foundSection);

        return "redirect:/sections/" + library_id;
    }

    @RequestMapping(value = "/sections/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model uiModel) {
        Section section = sectionService.findById(id);

        uiModel.addAttribute("section", section);

        return "section/edit";
    }

    @RequestMapping(value = "/sections/edit", method = RequestMethod.POST)
    public String edit(@RequestParam Integer library_id,  Section section) {
        section.setLibrary(libraryService.findById(library_id));

        sectionService.save(section);

        return "redirect:/sections/" + library_id;
    }

}
