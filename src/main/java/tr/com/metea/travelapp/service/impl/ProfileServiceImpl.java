package tr.com.metea.travelapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tr.com.metea.travelapp.domain.Profile;
import tr.com.metea.travelapp.dto.ProfileSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.ProfileWriteDTO;
import tr.com.metea.travelapp.exception.ServiceExecutionException;
import tr.com.metea.travelapp.repository.ProfileRepository;
import tr.com.metea.travelapp.service.ProfileService;
import tr.com.metea.travelapp.util.MessageUtil;
import tr.com.metea.travelapp.util.SessionContext;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final ModelMapper modelMapper;
    private final MessageUtil messageUtil;

    @Override
    public Profile save(ProfileWriteDTO profileWriteDTO) {
        final var profile = modelMapper.map(profileWriteDTO, Profile.class);
        profile.setUserId(SessionContext.getSessionData().getUserId());
        return profileRepository.save(profile);
    }

    @Override
    public Profile update(String id, ProfileWriteDTO profileWriteDTO) {
        final var profileDb = getById(id);
        final var updatedProfile = modelMapper.map(profileWriteDTO, Profile.class);
        updatedProfile.setId(profileDb.getId());
        updatedProfile.setUserId(profileDb.getUserId());
        updatedProfile.setCreDate(profileDb.getCreDate());
        updatedProfile.setCreUser(profileDb.getCreUser());
        return profileRepository.save(updatedProfile);
    }

    @Override
    public Profile getById(String id) {
        final var profileDB = profileRepository.findById(id);
        if (profileDB.isEmpty()) {
            throw new ServiceExecutionException(messageUtil.get("profile.not-found"));
        }
        return profileDB.get();
    }

    @Override
    public Profile delete(String id) {
        final var profileDb = getById(id);
        profileRepository.delete(profileDb);
        return profileDb;
    }

    @Override
    public Page<Profile> search(ProfileSearchCriteriaDTO filter, Pageable pageable) {
        return profileRepository.findAll(filter.ProfileSearchCriteriaFieldMapper(), pageable);
    }
}
