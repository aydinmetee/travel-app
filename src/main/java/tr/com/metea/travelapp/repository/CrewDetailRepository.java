package tr.com.metea.travelapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tr.com.metea.travelapp.domain.CrewDetail;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
public interface CrewDetailRepository extends JpaRepository<CrewDetail, String>,
        JpaSpecificationExecutor<CrewDetail> {
}
