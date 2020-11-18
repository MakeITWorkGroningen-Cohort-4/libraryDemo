package nl.miwgroningen.cohort4.vincent.libraryDemo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.filter.GenericFilterBean;

import javax.persistence.*;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 */

@Entity
public class Copy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer copyId;

    private Boolean available = true;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bookId", referencedColumnName = "bookId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Book book;

    public Integer getCopyId() {
        return copyId;
    }

    public void setCopyId(Integer copyId) {
        this.copyId = copyId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
