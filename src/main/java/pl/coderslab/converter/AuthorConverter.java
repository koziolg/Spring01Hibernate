package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.app.AuthorDao;
import pl.coderslab.model.Author;



@Component
public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    private AuthorDao authorDao;

    public AuthorConverter(){}

    @Override
    public Author convert(String s){
        Author author = authorDao.findById(Long.valueOf(s));
        return author;
    }

}
