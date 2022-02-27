package tr.com.metea.travelapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tr.com.metea.travelapp.domain.TripMaster;
import tr.com.metea.travelapp.dto.trip.TripMasterSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.trip.TripMasterWriteDTO;

/**
 * @author mete.aydin
 * @since 27.02.2022
 */
public interface TripMasterService {
    TripMaster save(TripMasterWriteDTO tripMasterWriteDTO);

    TripMaster update(String id, TripMasterWriteDTO tripMasterWriteDTO);

    TripMaster getById(String id);

    TripMaster delete(String id);

    Page<TripMaster> search(TripMasterSearchCriteriaDTO filter, Pageable pageable);
}
