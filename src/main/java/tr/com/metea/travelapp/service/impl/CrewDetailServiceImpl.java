package tr.com.metea.travelapp.service.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tr.com.metea.travelapp.domain.CrewDetail;
import tr.com.metea.travelapp.dto.crew.CrewDetailSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.crew.CrewDetailWriteDTO;
import tr.com.metea.travelapp.exception.ServiceExecutionException;
import tr.com.metea.travelapp.repository.CrewDetailRepository;
import tr.com.metea.travelapp.service.CrewDetailService;
import tr.com.metea.travelapp.service.CrewMasterService;
import tr.com.metea.travelapp.util.MessageUtil;
import tr.com.metea.travelapp.util.SessionContext;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
@Service
public class CrewDetailServiceImpl implements CrewDetailService {
    final CrewDetailRepository crewDetailRepository;
    final MessageUtil messageUtil;
    final CrewMasterService crewMasterService;

    public CrewDetailServiceImpl(CrewDetailRepository crewDetailRepository, MessageUtil messageUtil, @Lazy CrewMasterService crewMasterService) {
        this.crewDetailRepository = crewDetailRepository;
        this.crewMasterService = crewMasterService;
        this.messageUtil = messageUtil;
    }

    @Override
    public CrewDetail save(CrewDetailWriteDTO crewDetailWriteDTO) {
        final var crewMaster = crewMasterService.getById(crewDetailWriteDTO.getMasterId());
        final var crewDetail = new CrewDetail();
        crewDetail.setCrewMaster(crewMaster);
        crewDetail.setMemberId(SessionContext.getSessionData().getUserId());
        crewMasterService.increaseCrewMasterMemberCount(crewMaster.getId());
        return crewDetailRepository.save(crewDetail);
    }

    @Override
    public CrewDetail getById(String id) {
        final var crewDetail = crewDetailRepository.findById(id);
        if (crewDetail.isEmpty()) {
            throw new ServiceExecutionException(messageUtil.get("crew-detail.not-found"));
        }
        return crewDetail.get();
    }

    @Override
    public CrewDetail delete(String id) {
        final var crewDetail = getById(id);
        crewDetailRepository.delete(crewDetail);
        crewMasterService.decreaseCrewMasterMemberCount(crewDetail.getCrewMaster().getId());
        return crewDetail;
    }

    @Override
    public Page<CrewDetail> search(CrewDetailSearchCriteriaDTO filter, Pageable pageable) {
        return crewDetailRepository.findAll(filter.CrewDetailSearchCriteriaFieldMapper(), pageable);
    }
}
