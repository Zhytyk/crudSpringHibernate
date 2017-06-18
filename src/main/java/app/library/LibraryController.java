package app.library;

import app.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Pavel on 16-Jun-17.
 */

@Controller
public class LibraryController {
    private Service<Library> libraryService;

    @Autowired
    public void setLibraryService(Service<Library> libraryService) {
        this.libraryService = libraryService;
    }

    public Service<Library> getLibraryService() {
        return libraryService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model uiModel) {
        List<Library> libraries = libraryService.findAllById(null);

        uiModel.addAttribute("paul", "Paul");
        uiModel.addAttribute("libraries", libraries);

        return "library/index";
    }

    @RequestMapping(value = "/library/add", method = RequestMethod.GET)
    public String add() {
        return "library/add";
    }

    @RequestMapping(value = "/library/add", method = RequestMethod.POST)
    public String add(Library library) {
        library.setDate(new Date());

        libraryService.save(library);

        return "redirect:/";
    }

    @RequestMapping(value="/library/delete", method = RequestMethod.POST)
    public String delete(@RequestParam Integer id) {
        libraryService.delete(libraryService.findById(id));

        return "redirect:/";
    }

    @RequestMapping(value = "/library/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model uiModel){
        uiModel.addAttribute("library", libraryService.findById(id));

        return "/library/edit";
    }

    @RequestMapping(value = "/library/edit", method = RequestMethod.POST)
    public String edit(Library library) {
        libraryService.save(library);

        return "redirect:/";
    }
}
