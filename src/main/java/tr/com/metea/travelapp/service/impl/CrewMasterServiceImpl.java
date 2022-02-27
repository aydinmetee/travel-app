package tr.com.metea.travelapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tr.com.metea.travelapp.domain.CrewMaster;
import tr.com.metea.travelapp.dto.crew.CrewDetailWriteDTO;
import tr.com.metea.travelapp.dto.crew.CrewMasterSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.crew.CrewMasterWriteDTO;
import tr.com.metea.travelapp.exception.ServiceExecutionException;
import tr.com.metea.travelapp.repository.CrewMasterRepository;
import tr.com.metea.travelapp.service.CrewDetailService;
import tr.com.metea.travelapp.service.CrewMasterService;
import tr.com.metea.travelapp.util.MathUtil;
import tr.com.metea.travelapp.util.MessageUtil;
import tr.com.metea.travelapp.util.SessionContext;

import java.math.BigDecimal;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
@Service
@RequiredArgsConstructor
public class CrewMasterServiceImpl implements CrewMasterService {
    private final CrewMasterRepository crewMasterRepository;
    private final ModelMapper modelMapper;
    private final MessageUtil messageUtil;
    @Lazy
    private final CrewDetailService crewDetailService;

    @Override
    public CrewMaster save(CrewMasterWriteDTO crewMasterWriteDTO) {
        final var crewMaster = modelMapper.map(crewMasterWriteDTO, CrewMaster.class);
        crewMaster.setLeaderId(SessionContext.getSessionData().getUserId());
        crewMaster.setMemberCount(BigDecimal.ZERO);
        crewMaster.setStatus(CrewMaster.CrewStatus.ACTIVE);
        final var createdCrewMaster = crewMasterRepository.save(crewMaster);
        createCrewDetailForLeader(createdCrewMaster.getId());
        return createdCrewMaster;
    }

    @Override
    public CrewMaster update(String id, CrewMasterWriteDTO crewMasterWriteDTO) {
        final var updatedCrewMaster = getById(id);
        updatedCrewMaster.setCode(crewMasterWriteDTO.getCode());
        updatedCrewMaster.setDescription(crewMasterWriteDTO.getDescription());
        updatedCrewMaster.setName(crewMasterWriteDTO.getName());
        return crewMasterRepository.save(updatedCrewMaster);
    }

    @Override
    public CrewMaster getById(String id) {
        final var crewMaster = crewMasterRepository.findById(id);
        if (crewMaster.isEmpty()) {
            throw new ServiceExecutionException(messageUtil.get("crew-master.not-found"));
        }
        return crewMaster.get();
    }

    @Override
    public CrewMaster delete(String id) {
        final var crewMaster = getById(id);
        crewMasterRepository.delete(crewMaster);
        return crewMaster;
    }

    @Override
    public Page<CrewMaster> search(CrewMasterSearchCriteriaDTO filter, Pageable pageable) {
        return crewMasterRepository.findAll(filter.CrewMasterSearchCriteriaFieldMapper(), pageable);
    }

    @Override
    public void increaseCrewMasterMemberCount(String masterId) {
        final var crewMaster = getById(masterId);
        crewMaster.setMemberCount(MathUtil.add(crewMaster.getMemberCount(), BigDecimal.ONE));
        crewMasterRepository.save(crewMaster);
    }

    @Override
    public void decreaseCrewMasterMemberCount(String masterId) {
        final var crewMaster = getById(masterId);
        crewMaster.setMemberCount(MathUtil.subtract(crewMaster.getMemberCount(), BigDecimal.ONE));
        crewMasterRepository.save(crewMaster);
    }

    private void createCrewDetailForLeader(String masterId) {
        final var crewDetailDTO = new CrewDetailWriteDTO();
        crewDetailDTO.setMasterId(masterId);
        crewDetailService.save(crewDetailDTO);
    }
}
