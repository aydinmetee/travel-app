package tr.com.metea.travelapp.serviceview;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tr.com.metea.travelapp.dto.trip.TripDetailReadDTO;
import tr.com.metea.travelapp.dto.trip.TripDetailSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.trip.TripDetailWriteDTO;

/**
 * @author mete.aydin
 * @since 27.02.2022
 */
public interface TripDetailServiceView {
    TripDetailReadDTO save(TripDetailWriteDTO tripDetailWriteDTO);

    TripDetailReadDTO getById(String id);

    TripDetailReadDTO delete(String id);

    Page<TripDetailReadDTO> search(TripDetailSearchCriteriaDTO filter, Pageable pageable);

    TripDetailReadDTO markAsApprove(String id);

    TripDetailReadDTO markAsDenied(String id);

    TripDetailReadDTO markAsCancelled(String id);
}
