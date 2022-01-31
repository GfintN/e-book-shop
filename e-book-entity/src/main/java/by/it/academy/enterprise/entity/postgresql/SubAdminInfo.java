package by.it.academy.enterprise.entity.postgresql;

import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubAdminInfo {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="serial_sub_admin_info")
    @SequenceGenerator(name="serial_sub_admin_info", sequenceName="serial_sub_admin_info", allocationSize=1)
    @Column
    public Long id;

    @Column(nullable = false)
    public Long userId;

    @Column(nullable = false)
    public String macAddress;

    @Column(nullable = false)
    public String workingMail;

    @Column(nullable = false)
    public String firstName;

    @Column(nullable = false)
    public String surName;

    @Column(nullable = false)
    public String patronymic;
}
