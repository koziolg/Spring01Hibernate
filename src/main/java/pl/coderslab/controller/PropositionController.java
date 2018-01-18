package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.AuthorDao;
import pl.coderslab.app.BookDao;
import pl.coderslab.app.PublisherDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import java.util.List;

@Controller
@RequestMapping("/proposition")
public class PropositionController {

    @Autowired
    BookDao bookDao;
    @Autowired
    PublisherDao publisherDao;
    @Autowired
    AuthorDao authorDao;


    @GetMapping("/all")

    public String allPropositions(Model m){
        String result = "brak propozycji";
        List<Book> books = bookDao.findAll();
        List<Book> propositions = null;
        for(Book b: books){
            if(b.isProposition()== true){
                propositions.add(b);
            }

        }
        m.addAttribute("propositions", propositions);
        return "all_propositions";
    }

    @GetMapping("/add")
    public String addPropositions(Model m){
        List<Author> authors = authorDao.getAll();
        List<Publisher> publishers = publisherDao.getAll();
        m.addAttribute("book", new Book());
        m.addAttribute("authors", authors);
        m.addAttribute("publishers", publishers);
        return "add_propositions_form";
    }

    @PostMapping(value="/save")
    public String savePropositions (@ModelAttribute Book book){
        if(book.isProposition() == true){
            bookDao.save(book);
            return "redirect:all";
        } else {
            return "add_propositions_form";
        }
    }
}
