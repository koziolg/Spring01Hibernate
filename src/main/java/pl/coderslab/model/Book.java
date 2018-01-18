package pl.coderslab.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Size(min=5)
    private String title;
    @ManyToMany()
    @NotEmpty
    private List<Author> authors = new ArrayList<>();
    @Column(scale = 2, precision= 4)
    @Range(min=1, max=10)
    private Double rating;
    @Column(columnDefinition = "TEXT")
    @Size(max=600)
    private String description;


    @ManyToOne
    @JoinColumn(name= "publisher_id")
    @NotNull
    private Publisher publisher;
    @Min(value=2)
    private Integer pages;

    private boolean proposition;

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Double getRating() {
        return rating;
    }


    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public void setRating(Double rating) {
        this.rating = rating;
    }


    public void setDescription(String description) {
        this.description = description;
    }



    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public boolean isProposition() {
        return proposition;
    }

    public void setProposition(boolean proposition) {
        this.proposition = proposition;
    }
}