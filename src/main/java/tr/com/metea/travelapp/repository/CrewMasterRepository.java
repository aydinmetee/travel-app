package tr.com.metea.travelapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tr.com.metea.travelapp.domain.CrewMaster;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
public interface CrewMasterRepository extends JpaRepository<CrewMaster, String>,
        JpaSpecificationExecutor<CrewMaster> {
}
