package tr.com.metea.travelapp.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.metea.travelapp.dto.ProfileReadDTO;
import tr.com.metea.travelapp.dto.ProfileSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.ProfileWriteDTO;
import tr.com.metea.travelapp.serviceview.ProfileServiceView;

import javax.validation.Valid;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
@Api(value = "/profiles")
public class ProfilesController {
    private final ProfileServiceView profileServiceView;

    @PostMapping
    @ApiOperation(value = "Create Profile", response = ProfileReadDTO.class)
    public ResponseEntity<ProfileReadDTO> create(@Valid @RequestBody ProfileWriteDTO profileWriteDTO) {
        return ResponseEntity.ok(profileServiceView.save(profileWriteDTO));
    }

    @PutMapping("/{profileId}")
    @ApiOperation(value = "Update Profile", response = ProfileReadDTO.class)
    public ResponseEntity<ProfileReadDTO> update(@Valid @RequestBody ProfileWriteDTO profileWriteDTO,
                                                 @PathVariable("profileId") String profileId) {
        return ResponseEntity.ok(profileServiceView.update(profileId, profileWriteDTO));
    }

    @GetMapping("/{profileId}")
    @ApiOperation(value = "Get Profile", response = ProfileReadDTO.class)
    public ResponseEntity<ProfileReadDTO> getById(@PathVariable("profileId") String profileId) {
        return ResponseEntity.ok(profileServiceView.getById(profileId));
    }

    @DeleteMapping("/{profileId}")
    @ApiOperation(value = "Delete Profile", response = ProfileReadDTO.class)
    public ResponseEntity<ProfileReadDTO> delete(@PathVariable("profileId") String profileId) {
        return ResponseEntity.ok(profileServiceView.delete(profileId));
    }

    @PostMapping("/search")
    @ApiOperation(value = "Search Profile", response = Page.class)
    public ResponseEntity<Page<ProfileReadDTO>> search(@RequestBody() ProfileSearchCriteriaDTO filter,
                                                       @RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(profileServiceView.search(filter, PageRequest.of(page, size)));
    }
}
