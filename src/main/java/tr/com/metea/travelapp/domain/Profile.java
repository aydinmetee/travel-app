package tr.com.metea.travelapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
@RequiredArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "profile_def")
public class Profile extends BaseEntity {
    @Column(name = "firstname", length = 100)
    private String firstName;
    @Column(name = "lastname", length = 100)
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "phone_num", length = 20)
    private String phoneNumber;
    @Column(name = "user_id", length = 36)
    private String userId;
}
