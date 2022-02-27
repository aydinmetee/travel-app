package tr.com.metea.travelapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tr.com.metea.travelapp.domain.CrewMaster;
import tr.com.metea.travelapp.dto.crew.CrewMasterSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.crew.CrewMasterWriteDTO;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
public interface CrewMasterService {
    CrewMaster save(CrewMasterWriteDTO crewMasterWriteDTO);

    CrewMaster update(String id, CrewMasterWriteDTO crewMasterWriteDTO);

    CrewMaster getById(String id);

    CrewMaster delete(String id);

    Page<CrewMaster> search(CrewMasterSearchCriteriaDTO filter, Pageable pageable);

    void increaseCrewMasterMemberCount(String masterId);

    void decreaseCrewMasterMemberCount(String masterId);
}
