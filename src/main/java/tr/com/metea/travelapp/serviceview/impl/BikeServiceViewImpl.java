package tr.com.metea.travelapp.serviceview.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tr.com.metea.travelapp.domain.Bike;
import tr.com.metea.travelapp.dto.BikeReadDTO;
import tr.com.metea.travelapp.dto.BikeSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.BikeWriteDTO;
import tr.com.metea.travelapp.service.BikeService;
import tr.com.metea.travelapp.serviceview.BikeServiceView;

/**
 * @author mete.aydin
 * @since 27.02.2022
 */
@Service
@RequiredArgsConstructor
public class BikeServiceViewImpl implements BikeServiceView {
    private final BikeService bikeService;
    private final ModelMapper modelMapper;

    @Override
    public BikeReadDTO save(BikeWriteDTO bikeWriteDTO) {
        return convertToDTO(bikeService.save(bikeWriteDTO));
    }

    @Override
    public BikeReadDTO update(String id, BikeWriteDTO bikeWriteDTO) {
        return convertToDTO(bikeService.update(id, bikeWriteDTO));
    }

    @Override
    public BikeReadDTO getById(String id) {
        return convertToDTO(bikeService.getById(id));
    }

    @Override
    public BikeReadDTO delete(String id) {
        return convertToDTO(bikeService.delete(id));
    }

    @Override
    public Page<BikeReadDTO> search(BikeSearchCriteriaDTO filter, Pageable pageable) {
        return bikeService.search(filter, pageable).map(this::convertToDTO);
    }

    private BikeReadDTO convertToDTO(Bike bike) {
        return modelMapper.map(bike, BikeReadDTO.class);
    }
}
