package tr.com.metea.travelapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tr.com.metea.travelapp.domain.Profile;
import tr.com.metea.travelapp.dto.ProfileSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.ProfileWriteDTO;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
public interface ProfileService {
    Profile save(ProfileWriteDTO profileWriteDTO);

    Profile update(String id, ProfileWriteDTO profileWriteDTO);

    Profile getById(String id);

    Profile delete(String id);

    Page<Profile> search(ProfileSearchCriteriaDTO filter, Pageable pageable);

}
