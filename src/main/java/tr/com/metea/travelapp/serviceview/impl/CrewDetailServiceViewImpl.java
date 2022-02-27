package tr.com.metea.travelapp.serviceview.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tr.com.metea.travelapp.domain.CrewDetail;
import tr.com.metea.travelapp.dto.crew.CrewDetailReadDTO;
import tr.com.metea.travelapp.dto.crew.CrewDetailSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.crew.CrewDetailWriteDTO;
import tr.com.metea.travelapp.service.CrewDetailService;
import tr.com.metea.travelapp.serviceview.CrewDetailServiceView;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
@Service
@RequiredArgsConstructor
public class CrewDetailServiceViewImpl implements CrewDetailServiceView {
    private final CrewDetailService crewDetailService;
    private final ModelMapper modelMapper;

    @Override
    public CrewDetailReadDTO save(CrewDetailWriteDTO crewDetailWriteDTO) {
        return convertToDTO(crewDetailService.save(crewDetailWriteDTO));
    }

    @Override
    public CrewDetailReadDTO getById(String id) {
        return convertToDTO(crewDetailService.getById(id));
    }

    @Override
    public CrewDetailReadDTO delete(String id) {
        return convertToDTO(crewDetailService.delete(id));
    }

    @Override
    public Page<CrewDetailReadDTO> search(CrewDetailSearchCriteriaDTO crewDetailSearchCriteriaDTO, Pageable pageable) {
        return crewDetailService.search(crewDetailSearchCriteriaDTO, pageable).map(this::convertToDTO);
    }

    private CrewDetailReadDTO convertToDTO(CrewDetail crewDetail) {
        final var crewDetailDTO = modelMapper.map(crewDetail, CrewDetailReadDTO.class);
        crewDetailDTO.setMasterId(crewDetail.getCrewMaster().getId());
        return crewDetailDTO;
    }
}
