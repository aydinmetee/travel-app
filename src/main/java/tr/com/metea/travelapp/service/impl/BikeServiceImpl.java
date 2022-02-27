package tr.com.metea.travelapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tr.com.metea.travelapp.domain.Bike;
import tr.com.metea.travelapp.dto.BikeSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.BikeWriteDTO;
import tr.com.metea.travelapp.exception.ServiceExecutionException;
import tr.com.metea.travelapp.repository.BikeRepository;
import tr.com.metea.travelapp.service.BikeService;
import tr.com.metea.travelapp.util.MessageUtil;
import tr.com.metea.travelapp.util.SessionContext;

/**
 * @author mete.aydin
 * @since 27.02.2022
 */
@Service
@RequiredArgsConstructor
public class BikeServiceImpl implements BikeService {
    private final BikeRepository bikeRepository;
    private final ModelMapper modelMapper;
    private final MessageUtil messageUtil;

    @Override
    public Bike save(BikeWriteDTO bikeWriteDTO) {
        final var bike = modelMapper.map(bikeWriteDTO, Bike.class);
        bike.setOwnerId(SessionContext.getSessionData().getUserId());
        return bikeRepository.save(bike);
    }

    @Override
    public Bike update(String id, BikeWriteDTO bikeWriteDTO) {
        final var bikeDB = getById(id);
        bikeDB.setBrand(bikeWriteDTO.getBrand());
        bikeDB.setModel(bikeWriteDTO.getModel());
        return bikeRepository.save(bikeDB);
    }

    @Override
    public Bike getById(String id) {
        final var bikeDB = bikeRepository.findById(id);
        if (bikeDB.isEmpty()) {
            throw new ServiceExecutionException(messageUtil.get("bike.not-found"));
        }
        return bikeDB.get();
    }

    @Override
    public Bike delete(String id) {
        final var bikeDb = getById(id);
        bikeRepository.delete(bikeDb);
        return bikeDb;
    }

    @Override
    public Page<Bike> search(BikeSearchCriteriaDTO filter, Pageable pageable) {
        return bikeRepository.findAll(filter.BikeSearchCriteriaFieldMapper(), pageable);
    }
}
