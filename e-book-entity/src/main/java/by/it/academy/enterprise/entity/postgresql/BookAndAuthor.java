package by.it.academy.enterprise.entity.postgresql;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "book_and_author")
public class BookAndAuthor {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="serial_book_and_author")
    @SequenceGenerator(name="serial_book_and_author", sequenceName="serial_book_and_author", allocationSize=1)
    @Column
    public Long id;

    @Column(nullable = false)
    public String bookName;

    @Column(nullable = false)
    public String userId;

    @Column
    public LocalDate dateOfCreateBook;

    @Column
    public Short bookStatus;

    @Column
    public Integer bookPrice;
}
