package tr.com.metea.travelapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tr.com.metea.travelapp.domain.CrewDetail;
import tr.com.metea.travelapp.dto.crew.CrewDetailSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.crew.CrewDetailWriteDTO;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
public interface CrewDetailService {
    CrewDetail save(CrewDetailWriteDTO crewDetailWriteDTO);

    CrewDetail getById(String id);

    CrewDetail delete(String id);

    Page<CrewDetail> search(CrewDetailSearchCriteriaDTO filter, Pageable pageable);
}
