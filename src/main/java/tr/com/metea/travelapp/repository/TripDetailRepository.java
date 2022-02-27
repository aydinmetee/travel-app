package tr.com.metea.travelapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tr.com.metea.travelapp.domain.TripDetail;

/**
 * @author mete.aydin
 * @since 27.02.2022
 */
public interface TripDetailRepository extends JpaRepository<TripDetail, String>,
        JpaSpecificationExecutor<TripDetail> {
}
