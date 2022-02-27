package tr.com.metea.travelapp.serviceview.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tr.com.metea.travelapp.domain.TripDetail;
import tr.com.metea.travelapp.dto.trip.TripDetailReadDTO;
import tr.com.metea.travelapp.dto.trip.TripDetailSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.trip.TripDetailWriteDTO;
import tr.com.metea.travelapp.service.TripDetailService;
import tr.com.metea.travelapp.serviceview.TripDetailServiceView;

/**
 * @author mete.aydin
 * @since 27.02.2022
 */
@Service
@RequiredArgsConstructor
public class TripDetailServiceViewImpl implements TripDetailServiceView {
    private final TripDetailService tripDetailService;
    private final ModelMapper modelMapper;

    @Override
    public TripDetailReadDTO save(TripDetailWriteDTO tripDetailWriteDTO) {
        return convertToDTO(tripDetailService.save(tripDetailWriteDTO));
    }

    @Override
    public TripDetailReadDTO getById(String id) {
        return convertToDTO(tripDetailService.getById(id));
    }

    @Override
    public TripDetailReadDTO delete(String id) {
        return convertToDTO(tripDetailService.delete(id));
    }

    @Override
    public Page<TripDetailReadDTO> search(TripDetailSearchCriteriaDTO filter, Pageable pageable) {
        return tripDetailService.search(filter, pageable).map(this::convertToDTO);
    }

    @Override
    public TripDetailReadDTO markAsApprove(String id) {
        return convertToDTO(tripDetailService.markAsApprove(id));
    }

    @Override
    public TripDetailReadDTO markAsDenied(String id) {
        return convertToDTO(tripDetailService.markAsDenied(id));
    }

    @Override
    public TripDetailReadDTO markAsCancelled(String id) {
        return convertToDTO(tripDetailService.markAsCancelled(id));
    }

    private TripDetailReadDTO convertToDTO(TripDetail tripDetail) {
        final var dto = modelMapper.map(tripDetail, TripDetailReadDTO.class);
        dto.setMasterId(tripDetail.getTripMaster().getId());
        return dto;
    }
}
