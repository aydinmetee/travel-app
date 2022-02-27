package tr.com.metea.travelapp.serviceview;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tr.com.metea.travelapp.dto.BikeReadDTO;
import tr.com.metea.travelapp.dto.BikeSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.BikeWriteDTO;

/**
 * @author mete.aydin
 * @since 27.02.2022
 */
public interface BikeServiceView {
    BikeReadDTO save(BikeWriteDTO bikeWriteDTO);

    BikeReadDTO update(String id, BikeWriteDTO bikeWriteDTO);

    BikeReadDTO getById(String id);

    BikeReadDTO delete(String id);

    Page<BikeReadDTO> search(BikeSearchCriteriaDTO filter, Pageable pageable);
}
