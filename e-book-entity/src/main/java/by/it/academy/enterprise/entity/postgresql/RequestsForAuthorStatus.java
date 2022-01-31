package by.it.academy.enterprise.entity.postgresql;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestsForAuthorStatus {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="serial_requests_for_author_status")
    @SequenceGenerator(name="serial_requests_for_author_status", sequenceName="serial_requests_for_author_status", allocationSize=1)
    @Column
    public Long id;

    @Column(nullable = false)
    public Long userId;

    @Column(nullable = false)
    public String userName;

    @Column(nullable = false)
    public LocalDate dataMassage;

    @Column(nullable = false)
    public String[] firstOrTestBookTxt;

    @Column
    public Long idReviewer;
}
