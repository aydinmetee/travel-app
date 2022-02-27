package tr.com.metea.travelapp.serviceview.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tr.com.metea.travelapp.domain.Profile;
import tr.com.metea.travelapp.dto.ProfileReadDTO;
import tr.com.metea.travelapp.dto.ProfileSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.ProfileWriteDTO;
import tr.com.metea.travelapp.service.ProfileService;
import tr.com.metea.travelapp.serviceview.ProfileServiceView;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
@Service
@RequiredArgsConstructor
public class ProfileServiceViewImpl implements ProfileServiceView {
    private final ProfileService profileService;
    private final ModelMapper modelMapper;

    @Override
    public ProfileReadDTO save(ProfileWriteDTO profileWriteDTO) {
        return convertToDTO(profileService.save(profileWriteDTO));
    }

    @Override
    public ProfileReadDTO update(String id, ProfileWriteDTO profileWriteDTO) {
        return convertToDTO(profileService.update(id, profileWriteDTO));
    }

    @Override
    public ProfileReadDTO getById(String id) {
        return convertToDTO(profileService.getById(id));
    }

    @Override
    public ProfileReadDTO delete(String id) {
        return convertToDTO(profileService.delete(id));
    }

    @Override
    public Page<ProfileReadDTO> search(ProfileSearchCriteriaDTO profileSearchCriteriaDTO, Pageable pageable) {
        return profileService.search(profileSearchCriteriaDTO, pageable).map(this::convertToDTO);
    }

    private ProfileReadDTO convertToDTO(Profile profile) {
        return modelMapper.map(profile, ProfileReadDTO.class);
    }

}
