package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.app.PersonDao;
import pl.coderslab.app.PublisherDao;
import pl.coderslab.model.Publisher;
@Component
public class PublisherConverter implements Converter<String, Publisher> {
    @Autowired
    PublisherDao publisherDao;

    public PublisherConverter(){}

    @Override
    public Publisher convert(String s){
        Publisher publisher = publisherDao.findById(Long.valueOf(s));
        return publisher;
    }
}
