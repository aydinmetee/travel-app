package tr.com.metea.travelapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tr.com.metea.travelapp.domain.Bike;
import tr.com.metea.travelapp.dto.BikeSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.BikeWriteDTO;

/**
 * @author mete.aydin
 * @since 27.02.2022
 */
public interface BikeService {
    Bike save(BikeWriteDTO bikeWriteDTO);

    Bike update(String id, BikeWriteDTO bikeWriteDTO);

    Bike getById(String id);

    Bike delete(String id);

    Page<Bike> search(BikeSearchCriteriaDTO filter, Pageable pageable);
}
