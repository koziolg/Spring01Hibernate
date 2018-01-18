package pl.coderslab.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.model.Book;

public class SpringDiApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        BookDao bookDao = context.getBean(BookDao.class);

        Book book = new Book();
        book.setTitle("Alicja w kraine kodu");
        bookDao.save(book);

    }


}