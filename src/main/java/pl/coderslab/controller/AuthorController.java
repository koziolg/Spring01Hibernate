package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.AuthorDao;
import pl.coderslab.model.Author;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorDao authorDao;



    @GetMapping("/save")
    public String form() {
        return "add_author_form";
    }
    @PostMapping("/save")
    @ResponseBody
    public String save(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String yearOfBirth = request.getParameter("yearOfBirth");

        Author author = new Author();
       author.setFirstName(firstName);
       author.setLastName(lastName);
       author.setYearOfBirth(yearOfBirth);
       authorDao.save(author);
        return "Added new author id: " + author.getId();
    }

    @GetMapping("/{id}")
    public String get(Model m, @PathVariable long id){
        Author author = authorDao.findById(id);
        m.addAttribute("author", author);
        return "author_details";
    }

    @GetMapping("/update/{id}")
    public String updateForm ( Model m, @PathVariable long id){
        Author author = authorDao.findById(id);
        m.addAttribute("author", author);
        return "edit_author_form_bind";
    }
    @PostMapping("/update")
    public String updateAuthor(HttpServletRequest request){
        Author author = authorDao.findById(Long.valueOf(request.getParameter("id")));
        author.setFirstName(request.getParameter("firstName"));
        author.setLastName(request.getParameter("lastName"));
        authorDao.update(author);
        return "edit_author_form_bind";

    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable long id){
        authorDao.deleteById(id);
        return "Author deleted";
    }
}
