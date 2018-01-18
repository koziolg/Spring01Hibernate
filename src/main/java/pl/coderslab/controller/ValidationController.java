package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.util.Set;
@Controller
public class ValidationController {

    @Autowired
    Validator validator;

    @GetMapping("/validate")
    public String validate(){
        Book book = new Book();
        book.setPages(1);
        Set<ConstraintViolation<Book>> violations =  validator.validate(book);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage()); }
        } else {
            // save object
             } return "validate_result";

    }
}
