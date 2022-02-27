package tr.com.metea.travelapp.serviceview.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tr.com.metea.travelapp.domain.TripMaster;
import tr.com.metea.travelapp.dto.trip.TripMasterReadDTO;
import tr.com.metea.travelapp.dto.trip.TripMasterSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.trip.TripMasterWriteDTO;
import tr.com.metea.travelapp.service.TripMasterService;
import tr.com.metea.travelapp.serviceview.TripMasterServiceView;

/**
 * @author mete.aydin
 * @since 27.02.2022
 */
@Service
@RequiredArgsConstructor
public class TripMasterServiceViewImpl implements TripMasterServiceView {
    private final TripMasterService tripMasterService;
    private final ModelMapper modelMapper;

    @Override
    public TripMasterReadDTO save(TripMasterWriteDTO tripMasterWriteDTO) {
        return convertToDTO(tripMasterService.save(tripMasterWriteDTO));
    }

    @Override
    public TripMasterReadDTO update(String id, TripMasterWriteDTO tripMasterWriteDTO) {
        return convertToDTO(tripMasterService.update(id, tripMasterWriteDTO));
    }

    @Override
    public TripMasterReadDTO getById(String id) {
        return convertToDTO(tripMasterService.getById(id));
    }

    @Override
    public TripMasterReadDTO delete(String id) {
        return convertToDTO(tripMasterService.delete(id));
    }

    @Override
    public Page<TripMasterReadDTO> search(TripMasterSearchCriteriaDTO filter, Pageable pageable) {
        return tripMasterService.search(filter, pageable).map(this::convertToDTO);
    }

    private TripMasterReadDTO convertToDTO(TripMaster tripMaster) {
        final var tripDTO = modelMapper.map(tripMaster, TripMasterReadDTO.class);
        tripDTO.setCrewMasterId(tripMaster.getCrewMaster().getId());
        return tripDTO;
    }
}
