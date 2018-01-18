package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.AuthorDao;
import pl.coderslab.app.BookDao;
import pl.coderslab.app.PublisherDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/book")
public class BookController {



    @Autowired
    private BookDao bookDao;

    @Autowired
    private PublisherDao publisherDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private Validator validator;

    @GetMapping("/add")
    public String form(Model m) {
        List<Publisher> publishers = publisherDao.getAll();
        List<Author> authors = authorDao.getAll();
        m.addAttribute("book", new Book());
        m.addAttribute("publishers", publishers);
        m.addAttribute("authors", authors);
        return "add_book_form";
    }

//    @PostMapping("/save")
//    public String save(HttpServletRequest request, Model m) {
//
//        String title = request.getParameter("title");
//        String description = request.getParameter("description");
//        String pub_id = request.getParameter("publisher");
//        Book book = new Book();
//        List<Author> authorList = new ArrayList<>();
//        String[] authors = request.getParameterValues("author");
//        for(String id: authors) {
//            Author author = authorDao.findById(Long.valueOf(id));
//            authorList.add(author);
//        }
//        book.setAuthors(authorList);
//        book.setDescription(description);
//        book.setTitle(title);
//        Publisher publisher = publisherDao.findById(Long.valueOf(pub_id));
//        book.setPublisher(publisher);
//        Set<ConstraintViolation<Book>> violations  = validator.validate(book);
//        if (!violations.isEmpty()) {
//             m.addAttribute("violations", violations);
//             return "validate_result";
//        } else {
//            bookDao.save(book);
//        }
//        return "redirect:all";
//    }

    @PostMapping(value ="/save")
   public String save(@Valid Book book, BindingResult result) {
    if(result.hasErrors()){
        return "add_book_form";
    }
           bookDao.save(book);

        return "redirect:all";

    }

//    @PostMapping("/update")
//    @ResponseBody
//    public String update(HttpServletRequest request) {
//        String title = request.getParameter("title");
//        String author = request.getParameter("author");
//        String description = request.getParameter("description");
//        String publisher = request.getParameter("publisher");
//        Book book = new Book();
//        book.setAuthor(author);
//        book.setDescription(description);
//        book.setPublisher(publisher);
//        book.setTitle(title);
//        bookDao.update(book);
//        return "Updated Book";
//
//    }

  @GetMapping("/{id}")
  public String show(Model m, @PathVariable long id){
        Book book = bookDao.findById(id);
        m.addAttribute("book", book);

        return "book_details";
  }

@GetMapping("/update/{id}")
    public String updateForm ( Model m, @PathVariable long id){
        List<Publisher> publishers = publisherDao.getAll();
         List<Author> authors = authorDao.getAll();
        Book book = bookDao.findById(id);
        m.addAttribute("book", book);
        m.addAttribute("publishers", publishers);
        m.addAttribute("authors", authors);
        return "edit_book_form_bind";
}

 //   @PostMapping("/update")
  //      public String updateBook(HttpServletRequest request){
  //      Book book = bookDao.findById(Long.valueOf(request.getParameter("id")));
//
   //         bookDao.update(book);
   //         return "edit_book_form_bind";

  //  }
  @PostMapping("/update")

        public String updateBook(@ModelAttribute Book book, BindingResult result){
      if(result.hasErrors()){
          return "edit_book_form_bind";
      }
        bookDao.update(book);
      return "redirect:all";
  }

    @GetMapping("/deleteAsk/{id}")
    public String deleteBook(Model m, @PathVariable long id){
        m.addAttribute("id", id);
        return "confirm_delete";
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id){
        bookDao.deleteById(id);
        return "book deleted";
    }

    @GetMapping("/all")
    public String allBooks(Model m){
       List<Book> books =  bookDao.findAll();
       m.addAttribute("books", books);
       return "all_books";

    }

    @ModelAttribute("authors")
    List<Author> getAuthor(){
        return authorDao.getAll(); }


        @ModelAttribute("publishers")
    List<Publisher> getPublisher(){
        return publisherDao.getAll();
        }

}

