package tr.com.metea.travelapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import tr.com.metea.travelapp.util.IdGenerator;

import javax.persistence.*;

/**
 * @author Mete Aydin
 * @since 23.10.2021
 */
@RequiredArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "auth_user")
public class AuthUser {
    @Id
    @Column(name = "ID", nullable = false, length = 36)
    private String id;
    @Column(name = "username", length = 100, unique = true)
    private String username;
    @Column(name = "password", length = 200)
    private String password;
    @Column(name = "email", length = 100, unique = true)
    private String email;

    @PrePersist
    public void onPrePersist() {
        setId(IdGenerator.getUUID());
    }

}
