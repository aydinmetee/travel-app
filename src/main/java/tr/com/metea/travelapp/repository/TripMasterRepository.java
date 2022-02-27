package tr.com.metea.travelapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tr.com.metea.travelapp.domain.TripMaster;

/**
 * @author mete.aydin
 * @since 27.02.2022
 */
public interface TripMasterRepository extends JpaRepository<TripMaster, String>,
        JpaSpecificationExecutor<TripMaster> {
}
