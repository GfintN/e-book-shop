package by.it.academy.enterprise.entity.postgresql;

import lombok.*;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsersDataChangeTransaction {
    @Id
    @Column
    public Long userId;

    @Column (nullable = false)
    public LocalDate dateChanges;

    @Column
    public String beforePassword;

    @Column
    public String newPassword;

    @Column
    public String[] beforeMail;

    @Column
    public String newMail;

    @Column
    public String beforeUsername;

    @Column
    public String newUsername;

}
