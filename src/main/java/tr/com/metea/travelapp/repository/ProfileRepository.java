package tr.com.metea.travelapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tr.com.metea.travelapp.domain.Profile;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
public interface ProfileRepository extends JpaRepository<Profile, String>,
        JpaSpecificationExecutor<Profile> {
}
