package tr.com.metea.travelapp.serviceview;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tr.com.metea.travelapp.dto.trip.TripMasterReadDTO;
import tr.com.metea.travelapp.dto.trip.TripMasterSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.trip.TripMasterWriteDTO;

/**
 * @author mete.aydin
 * @since 27.02.2022
 */
public interface TripMasterServiceView {
    TripMasterReadDTO save(TripMasterWriteDTO tripMasterWriteDTO);

    TripMasterReadDTO update(String id, TripMasterWriteDTO tripMasterWriteDTO);

    TripMasterReadDTO getById(String id);

    TripMasterReadDTO delete(String id);

    Page<TripMasterReadDTO> search(TripMasterSearchCriteriaDTO filter, Pageable pageable);
}
