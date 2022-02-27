package tr.com.metea.travelapp.serviceview;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tr.com.metea.travelapp.dto.ProfileReadDTO;
import tr.com.metea.travelapp.dto.ProfileSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.ProfileWriteDTO;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
public interface ProfileServiceView {
    ProfileReadDTO save(ProfileWriteDTO profileWriteDTO);

    ProfileReadDTO update(String id, ProfileWriteDTO profileWriteDTO);

    ProfileReadDTO getById(String id);

    ProfileReadDTO delete(String id);

    Page<ProfileReadDTO> search(ProfileSearchCriteriaDTO profileSearchCriteriaDTO, Pageable pageable);

}
