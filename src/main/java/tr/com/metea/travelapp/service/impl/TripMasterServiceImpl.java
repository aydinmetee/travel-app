package tr.com.metea.travelapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tr.com.metea.travelapp.domain.TripDetail;
import tr.com.metea.travelapp.domain.TripMaster;
import tr.com.metea.travelapp.dto.trip.TripDetailWriteDTO;
import tr.com.metea.travelapp.dto.trip.TripMasterSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.trip.TripMasterWriteDTO;
import tr.com.metea.travelapp.exception.ServiceExecutionException;
import tr.com.metea.travelapp.repository.TripMasterRepository;
import tr.com.metea.travelapp.service.CrewMasterService;
import tr.com.metea.travelapp.service.TripDetailService;
import tr.com.metea.travelapp.service.TripMasterService;
import tr.com.metea.travelapp.util.MessageUtil;
import tr.com.metea.travelapp.util.SessionContext;

/**
 * @author mete.aydin
 * @since 27.02.2022
 */
@Service
@RequiredArgsConstructor
public class TripMasterServiceImpl implements TripMasterService {
    private final TripMasterRepository tripMasterRepository;
    private final ModelMapper modelMapper;
    private final CrewMasterService crewMasterService;
    private final MessageUtil messageUtil;
    @Lazy
    private final TripDetailService tripDetailService;

    @Override
    public TripMaster save(TripMasterWriteDTO tripMasterWriteDTO) {
        final var tripMaster = modelMapper.map(tripMasterWriteDTO, TripMaster.class);
        final var crewMaster = crewMasterService.getById(tripMasterWriteDTO.getCrewMasterId());
        tripMaster.setAssigneeId(SessionContext.getSessionData().getUserId());
        tripMaster.setCrewMaster(crewMaster);
        final var createdTripMaster = tripMasterRepository.save(tripMaster);
        final var createdTripDetail = createDetailForMaster(createdTripMaster);
        tripDetailService.markAsApprove(createdTripDetail.getId());
        return createdTripMaster;
    }

    @Override
    public TripMaster update(String id, TripMasterWriteDTO tripMasterWriteDTO) {
        final var updatedTripMaster = getById(id);
        final var updatedCrewMaster = crewMasterService.getById(tripMasterWriteDTO.getCrewMasterId());
        updatedTripMaster.setCrewMaster(updatedCrewMaster);
        updatedTripMaster.setStartDate(tripMasterWriteDTO.getStartDate());
        updatedTripMaster.setEndDate(tripMasterWriteDTO.getEndDate());
        updatedTripMaster.setStartLocation(tripMasterWriteDTO.getStartLocation());
        updatedTripMaster.setEndLocation(tripMasterWriteDTO.getEndLocation());
        updatedTripMaster.setCrewOnly(tripMasterWriteDTO.getCrewOnly());
        return tripMasterRepository.save(updatedTripMaster);
    }

    @Override
    public TripMaster getById(String id) {
        final var tripMaster = tripMasterRepository.findById(id);
        if (tripMaster.isEmpty()) {
            throw new ServiceExecutionException(messageUtil.get("trip-master.not-found"));
        }
        return tripMaster.get();
    }

    @Override
    public TripMaster delete(String id) {
        final var tripMaster = getById(id);
        tripMasterRepository.delete(tripMaster);
        return tripMaster;
    }

    @Override
    public Page<TripMaster> search(TripMasterSearchCriteriaDTO filter, Pageable pageable) {
        return tripMasterRepository.findAll(filter.TripMasterSearchCriteriaFieldMapper(), pageable);
    }

    private TripDetail createDetailForMaster(TripMaster tripMaster) {
        final var tripDetail = new TripDetailWriteDTO();
        tripDetail.setMasterId(tripMaster.getId());
        tripDetail.setParticipantId(tripMaster.getAssigneeId());
        return tripDetailService.save(tripDetail);
    }
}
