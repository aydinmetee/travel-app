package tr.com.metea.travelapp.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tr.com.metea.travelapp.domain.TripDetail;
import tr.com.metea.travelapp.dto.trip.TripDetailSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.trip.TripDetailWriteDTO;
import tr.com.metea.travelapp.exception.ServiceExecutionException;
import tr.com.metea.travelapp.repository.TripDetailRepository;
import tr.com.metea.travelapp.service.TripDetailService;
import tr.com.metea.travelapp.service.TripMasterService;
import tr.com.metea.travelapp.util.MessageUtil;

/**
 * @author mete.aydin
 * @since 27.02.2022
 */
@Service
public class TripDetailServiceImpl implements TripDetailService {
    final TripDetailRepository tripDetailRepository;
    final ModelMapper modelMapper;
    final MessageUtil messageUtil;
    final TripMasterService tripMasterService;

    public TripDetailServiceImpl(TripDetailRepository tripDetailRepository,
                                 ModelMapper modelMapper,
                                 MessageUtil messageUtil,
                                 @Lazy TripMasterService tripMasterService) {
        this.tripDetailRepository = tripDetailRepository;
        this.tripMasterService = tripMasterService;
        this.modelMapper = modelMapper;
        this.messageUtil = messageUtil;
    }

    @Override
    public TripDetail save(TripDetailWriteDTO tripDetailWriteDTO) {
        final var tripDetail = modelMapper.map(tripDetailWriteDTO, TripDetail.class);
        final var tripMaster = tripMasterService.getById(tripDetailWriteDTO.getMasterId());
        tripDetail.setTripMaster(tripMaster);
        tripDetail.setStatus(TripDetail.ParticipantStatus.WAIT4APP);
        return tripDetailRepository.save(tripDetail);
    }

    @Override
    public TripDetail getById(String id) {
        final var tripDetail = tripDetailRepository.findById(id);
        if (tripDetail.isEmpty()) {
            throw new ServiceExecutionException(messageUtil.get("trip-detail.not-found"));
        }
        return tripDetail.get();
    }

    @Override
    public TripDetail delete(String id) {
        final var tripDetail = getById(id);
        tripDetailRepository.delete(tripDetail);
        return tripDetail;
    }

    @Override
    public Page<TripDetail> search(TripDetailSearchCriteriaDTO filter, Pageable pageable) {
        return tripDetailRepository.findAll(filter.TripDetailSearchCriteriaFieldMapper(), pageable);
    }

    @Override
    public TripDetail markAsApprove(String id) {
        final var tripDetail = getById(id);
        tripDetail.setStatus(TripDetail.ParticipantStatus.APPROVED);
        return tripDetailRepository.save(tripDetail);
    }

    @Override
    public TripDetail markAsDenied(String id) {
        final var tripDetail = getById(id);
        tripDetail.setStatus(TripDetail.ParticipantStatus.DENIED);
        return tripDetailRepository.save(tripDetail);
    }

    @Override
    public TripDetail markAsCancelled(String id) {
        final var tripDetail = getById(id);
        tripDetail.setStatus(TripDetail.ParticipantStatus.CANCELLED);
        return tripDetailRepository.save(tripDetail);
    }
}
