package pl.coderslab.app;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Author;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Publisher publisher) {
        entityManager.persist(publisher);
    }

    public void update(Publisher publisher) {
        entityManager.merge(publisher);
    }

    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void deleteById(long id) {
        Publisher publisher = findById(id);
        entityManager.remove(entityManager.contains(publisher) ? publisher : entityManager.merge(publisher));
    }

    public PublisherDao() {
    }
    public List<Publisher> getAll(){
       Query query =  entityManager.createQuery("SELECT p from Publisher p ");
       return query.getResultList();
    }
}
