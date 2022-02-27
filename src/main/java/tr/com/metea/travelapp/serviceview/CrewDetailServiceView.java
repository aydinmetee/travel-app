package tr.com.metea.travelapp.serviceview;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tr.com.metea.travelapp.dto.crew.CrewDetailReadDTO;
import tr.com.metea.travelapp.dto.crew.CrewDetailSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.crew.CrewDetailWriteDTO;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
public interface CrewDetailServiceView {
    CrewDetailReadDTO save(CrewDetailWriteDTO crewDetailWriteDTO);

    CrewDetailReadDTO getById(String id);

    CrewDetailReadDTO delete(String id);

    Page<CrewDetailReadDTO> search(CrewDetailSearchCriteriaDTO crewDetailSearchCriteriaDTO, Pageable pageable);
}
