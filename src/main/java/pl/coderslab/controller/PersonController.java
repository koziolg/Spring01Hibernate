package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.DTO.PersonDTO;
import pl.coderslab.app.PersonDao;
import pl.coderslab.model.Gender;
import pl.coderslab.model.Person;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {


    @Autowired
    PersonDao personDao;
    @Autowired
    PersonDTO personDTO;
    @GetMapping("/form")
    public String showForm(Model m){
        m.addAttribute("person", new Person());
        return "person_add_form";
    }

    @PostMapping("/add")
    @ResponseBody
    public String savePerson(@ModelAttribute Person person){
        personDao.save(person);
        return "saved";
    }

    @ModelAttribute("countries")
    public String[] countries(){
        return personDTO.getCountries();

    }

    @ModelAttribute("gender")
    public List<Gender> getGender(){
       return personDTO.getGenders();
    }

    @GetMapping("/update/{id}")
    public String updateForm ( Model m, @PathVariable long id){
        Person person = personDao.findById(id);
        m.addAttribute("person", person);
        return "person_update_form";
    }

    @PostMapping("/update")
    @ResponseBody
    public String updatePerson(@ModelAttribute Person person){

        personDao.update(person);
        return "person updated";

    }
}
