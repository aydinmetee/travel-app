package tr.com.metea.travelapp.serviceview.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tr.com.metea.travelapp.domain.CrewMaster;
import tr.com.metea.travelapp.dto.crew.CrewMasterReadDTO;
import tr.com.metea.travelapp.dto.crew.CrewMasterSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.crew.CrewMasterWriteDTO;
import tr.com.metea.travelapp.service.CrewMasterService;
import tr.com.metea.travelapp.serviceview.CrewMasterServiceView;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
@Service
@RequiredArgsConstructor
public class CrewMasterServiceViewImpl implements CrewMasterServiceView {
    private final ModelMapper modelMapper;
    private final CrewMasterService crewMasterService;

    @Override
    public CrewMasterReadDTO save(CrewMasterWriteDTO crewMasterWriteDTO) {
        return convertToDTO(crewMasterService.save(crewMasterWriteDTO));
    }

    @Override
    public CrewMasterReadDTO update(String id, CrewMasterWriteDTO crewMasterWriteDTO) {
        return convertToDTO(crewMasterService.update(id, crewMasterWriteDTO));
    }

    @Override
    public CrewMasterReadDTO getById(String id) {
        return convertToDTO(crewMasterService.getById(id));
    }

    @Override
    public CrewMasterReadDTO delete(String id) {
        return convertToDTO(crewMasterService.delete(id));
    }

    @Override
    public Page<CrewMasterReadDTO> search(CrewMasterSearchCriteriaDTO crewMasterSearchCriteriaDTO, Pageable pageable) {
        return crewMasterService.search(crewMasterSearchCriteriaDTO, pageable).map(this::convertToDTO);
    }

    private CrewMasterReadDTO convertToDTO(CrewMaster crewMaster) {
        return modelMapper.map(crewMaster, CrewMasterReadDTO.class);
    }
}
