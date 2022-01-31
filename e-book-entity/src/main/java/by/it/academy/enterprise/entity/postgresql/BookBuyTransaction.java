package by.it.academy.enterprise.entity.postgresql;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookBuyTransaction {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="serial_book_buy_transaction")
    @SequenceGenerator(name="serial_book_buy_transaction", sequenceName="serial_book_buy_transaction", allocationSize=1)
    @Column
    public Long id;

    @Column(nullable = false)
    public LocalDate timeStartTransaction;

    @Column(nullable = false)
    public Long userId;

    @Column
    public Long boolOutMoney;

    @Column
    public Long boolInpMoney;

    @Column
    public LocalDate timeEndTransaction;

}
