package tr.com.metea.travelapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tr.com.metea.travelapp.domain.TripDetail;
import tr.com.metea.travelapp.dto.trip.TripDetailSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.trip.TripDetailWriteDTO;

/**
 * @author mete.aydin
 * @since 27.02.2022
 */
public interface TripDetailService {
    TripDetail save(TripDetailWriteDTO tripDetailWriteDTO);

    TripDetail getById(String id);

    TripDetail delete(String id);

    Page<TripDetail> search(TripDetailSearchCriteriaDTO filter, Pageable pageable);

    TripDetail markAsApprove(String id);

    TripDetail markAsDenied(String id);

    TripDetail markAsCancelled(String id);

}
