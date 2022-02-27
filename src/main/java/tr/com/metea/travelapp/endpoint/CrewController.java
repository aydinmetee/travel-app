package tr.com.metea.travelapp.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.metea.travelapp.dto.crew.*;
import tr.com.metea.travelapp.serviceview.CrewDetailServiceView;
import tr.com.metea.travelapp.serviceview.CrewMasterServiceView;

import javax.validation.Valid;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
@RestController
@RequestMapping("/crew")
@RequiredArgsConstructor
@Api(value = "/crew")
public class CrewController {
    private final CrewMasterServiceView crewMasterServiceView;
    private final CrewDetailServiceView crewDetailServiceView;

    @PostMapping
    @ApiOperation(value = "Create Crew Master", response = CrewMasterReadDTO.class)
    public ResponseEntity<CrewMasterReadDTO> createMaster(@Valid @RequestBody CrewMasterWriteDTO crewMasterWriteDTO) {
        return ResponseEntity.ok(crewMasterServiceView.save(crewMasterWriteDTO));
    }

    @PutMapping("/{crewId}")
    @ApiOperation(value = "Update Crew Master", response = CrewMasterReadDTO.class)
    public ResponseEntity<CrewMasterReadDTO> updateMaster(@Valid @RequestBody CrewMasterWriteDTO crewMasterWriteDTO,
                                                          @PathVariable("crewId") String crewId) {
        return ResponseEntity.ok(crewMasterServiceView.update(crewId, crewMasterWriteDTO));
    }

    @GetMapping("/{crewId}")
    @ApiOperation(value = "Get Crew Master", response = CrewMasterReadDTO.class)
    public ResponseEntity<CrewMasterReadDTO> getByIdMaster(@PathVariable("crewId") String crewId) {
        return ResponseEntity.ok(crewMasterServiceView.getById(crewId));
    }

    @DeleteMapping("/{crewId}")
    @ApiOperation(value = "Delete Crew Master", response = CrewMasterReadDTO.class)
    public ResponseEntity<CrewMasterReadDTO> deleteMaster(@PathVariable("crewId") String crewId) {
        return ResponseEntity.ok(crewMasterServiceView.delete(crewId));
    }

    @PostMapping("/search")
    @ApiOperation(value = "Search Crew Master", response = Page.class)
    public ResponseEntity<Page<CrewMasterReadDTO>> searchMaster(@RequestBody() CrewMasterSearchCriteriaDTO filter,
                                                                @RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(crewMasterServiceView.search(filter, PageRequest.of(page, size)));
    }

    @PostMapping("/{crewId}/detail")
    @ApiOperation(value = "Create Crew Detail", response = CrewDetailReadDTO.class)
    public ResponseEntity<CrewDetailReadDTO> createDetail(@Valid @RequestBody CrewDetailWriteDTO crewDetailWriteDTO,
                                                          @PathVariable("crewId") String crewId) {
        crewDetailWriteDTO.setMasterId(crewId);
        return ResponseEntity.ok(crewDetailServiceView.save(crewDetailWriteDTO));
    }

    @GetMapping("/{crewId}/detail/{id}")
    @ApiOperation(value = "Get Crew Detail", response = CrewDetailReadDTO.class)
    public ResponseEntity<CrewDetailReadDTO> getByIdDetail(@PathVariable("crewId") String crewId,
                                                           @PathVariable("id") String id) {
        return ResponseEntity.ok(crewDetailServiceView.getById(id));
    }

    @DeleteMapping("/{crewId}/detail/{id}")
    @ApiOperation(value = "Delete Crew Detail", response = CrewDetailReadDTO.class)
    public ResponseEntity<CrewDetailReadDTO> deleteDetail(@PathVariable("crewId") String crewId,
                                                          @PathVariable("id") String id) {
        return ResponseEntity.ok(crewDetailServiceView.delete(id));
    }

    @PostMapping("/detail/search")
    @ApiOperation(value = "Search Crew Detail", response = Page.class)
    public ResponseEntity<Page<CrewDetailReadDTO>> searchDetail(@RequestBody() CrewDetailSearchCriteriaDTO filter,
                                                                @RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(crewDetailServiceView.search(filter, PageRequest.of(page, size)));
    }
}
