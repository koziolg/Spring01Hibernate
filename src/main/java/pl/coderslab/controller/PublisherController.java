package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.PublisherDao;
import pl.coderslab.model.Publisher;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

//    @Autowired
//    PublisherRepository publisherRepository;

    @Autowired
    PublisherDao publisherDao;

    @GetMapping("/save")
    public String form() {
        return "add_publisher_form";
    }
    @PostMapping("/save")
    @ResponseBody
    public String save(HttpServletRequest request) {
        String name = request.getParameter("name");


        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisherDao.save(publisher);
        return "Added new publisher id: " + publisher.getId();
    }

    @GetMapping("/{id}")
    public String get(Model m, @PathVariable long id){
        Publisher publisher = publisherDao.findById(id);
        m.addAttribute("publisher", publisher);
        return "publisher_details";
    }

    @GetMapping("/update/{id}")
    public String updateForm ( Model m, @PathVariable long id){
        Publisher publisher = publisherDao.findById(id);
        m.addAttribute("publisher", publisher);
        return "edit_publisher_form_bind";
    }
    @PostMapping("/update")
    public String updateAuthor(HttpServletRequest request){
        Publisher publisher = publisherDao.findById(Long.valueOf(request.getParameter("id")));
        publisher.setName(request.getParameter("name"));
        publisherDao.update(publisher);
        return "edit_publisher_form_bind";

    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable long id){
        publisherDao.deleteById(id);
        return "Publisher deleted";
    }
}

