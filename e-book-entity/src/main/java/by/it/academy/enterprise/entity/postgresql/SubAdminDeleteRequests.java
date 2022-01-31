package by.it.academy.enterprise.entity.postgresql;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubAdminDeleteRequests {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="serial_sub_admin_del")
    @SequenceGenerator(name="serial_sub_admin_del", sequenceName="serial_sub_admin_del", allocationSize=1)
    @Column
    public Long id;

    @Column(nullable = false)
    public String causeDismissal;

    @Column(nullable = false)
    public LocalDate requestsDate;


}
