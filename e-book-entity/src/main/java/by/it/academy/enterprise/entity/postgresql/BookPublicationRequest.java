package by.it.academy.enterprise.entity.postgresql;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookPublicationRequest {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="serial_book_publication_request")
    @SequenceGenerator(name="serial_book_publication_request", sequenceName="serial_book_publication_request", allocationSize=1)
    @Column
    public Long id;

    @Column(nullable = false)
    public Long userId;

    @Column(nullable = false)
    public String bookOrCollectionName;

    @Column
    public String[] booksInCollectionName;

    @Column
    public String[] txtFilePath;

    @Column
    public Long idReviewer;
}
