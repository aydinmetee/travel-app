package tr.com.metea.travelapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.metea.travelapp.domain.AuthUser;

public interface AuthUserRepository extends JpaRepository<AuthUser, String> {
    AuthUser findAuthUserByUsername(String username);
}
