package tr.com.metea.travelapp.serviceview;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tr.com.metea.travelapp.dto.crew.CrewMasterReadDTO;
import tr.com.metea.travelapp.dto.crew.CrewMasterSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.crew.CrewMasterWriteDTO;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
public interface CrewMasterServiceView {
    CrewMasterReadDTO save(CrewMasterWriteDTO crewMasterWriteDTO);

    CrewMasterReadDTO update(String id, CrewMasterWriteDTO crewMasterWriteDTO);

    CrewMasterReadDTO getById(String id);

    CrewMasterReadDTO delete(String id);

    Page<CrewMasterReadDTO> search(CrewMasterSearchCriteriaDTO crewMasterSearchCriteriaDTO, Pageable pageable);
}
