package by.it.academy.enterprise.entity.postgresql;

import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewerInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="serial_reviewer_info")
    @SequenceGenerator(name="serial_reviewer_info", sequenceName="serial_reviewer_info", allocationSize=1)
    @Column
    public Long id;

    @Column(nullable = false)
    public Long userId;

    @Column(nullable = false)
    public String macAddress;

    @Column(nullable = false)
    public String firstName;

    @Column(nullable = false)
    public String surName;

    @Column(nullable = false)
    public String patronymic;

    @Column(nullable = false)
    public LocalDate hiringDate;

    @Column
    public LocalDate dismissalDate;

    @Column
    public String causeDismissal;
}
