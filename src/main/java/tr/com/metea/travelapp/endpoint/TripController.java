package tr.com.metea.travelapp.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.metea.travelapp.dto.trip.*;
import tr.com.metea.travelapp.serviceview.TripDetailServiceView;
import tr.com.metea.travelapp.serviceview.TripMasterServiceView;

import javax.validation.Valid;

/**
 * @author mete.aydin
 * @since 27.02.2022
 */
@RestController
@RequestMapping("/trip")
@RequiredArgsConstructor
@Api(value = "/trip")
public class TripController {
    private final TripMasterServiceView tripMasterServiceView;
    private final TripDetailServiceView tripDetailServiceView;

    @PostMapping
    @ApiOperation(value = "Create Trip Master", response = TripMasterReadDTO.class)
    public ResponseEntity<TripMasterReadDTO> createMaster(@Valid @RequestBody TripMasterWriteDTO tripMasterWriteDTO) {
        return ResponseEntity.ok(tripMasterServiceView.save(tripMasterWriteDTO));
    }

    @PutMapping("/{tripId}")
    @ApiOperation(value = "Update Trip Master", response = TripMasterReadDTO.class)
    public ResponseEntity<TripMasterReadDTO> updateMaster(@Valid @RequestBody TripMasterWriteDTO tripMasterWriteDTO,
                                                          @PathVariable("tripId") String tripId) {
        return ResponseEntity.ok(tripMasterServiceView.update(tripId, tripMasterWriteDTO));
    }

    @GetMapping("/{tripId}")
    @ApiOperation(value = "Get Trip Master", response = TripMasterReadDTO.class)
    public ResponseEntity<TripMasterReadDTO> getByIdMaster(@PathVariable("tripId") String tripId) {
        return ResponseEntity.ok(tripMasterServiceView.getById(tripId));
    }

    @DeleteMapping("/{tripId}")
    @ApiOperation(value = "Delete Trip Master", response = TripMasterReadDTO.class)
    public ResponseEntity<TripMasterReadDTO> deleteMaster(@PathVariable("tripId") String tripId) {
        return ResponseEntity.ok(tripMasterServiceView.delete(tripId));
    }

    @PostMapping("/search")
    @ApiOperation(value = "Search Trip Master", response = Page.class)
    public ResponseEntity<Page<TripMasterReadDTO>> searchMaster(@RequestBody() TripMasterSearchCriteriaDTO filter,
                                                                @RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(tripMasterServiceView.search(filter, PageRequest.of(page, size)));
    }

    @PostMapping("/{tripId}/detail")
    @ApiOperation(value = "Create Trip Detail", response = TripDetailReadDTO.class)
    public ResponseEntity<TripDetailReadDTO> createDetail(@Valid @RequestBody TripDetailWriteDTO tripDetailWriteDTO,
                                                          @PathVariable("tripId") String tripId) {
        tripDetailWriteDTO.setMasterId(tripId);
        return ResponseEntity.ok(tripDetailServiceView.save(tripDetailWriteDTO));
    }

    @GetMapping("/{tripId}/detail/{id}")
    @ApiOperation(value = "Get Trip Detail", response = TripDetailReadDTO.class)
    public ResponseEntity<TripDetailReadDTO> getByIdDetail(@PathVariable("tripId") String tripId,
                                                           @PathVariable("id") String id) {
        return ResponseEntity.ok(tripDetailServiceView.getById(id));
    }

    @DeleteMapping("/{tripId}/detail/{id}")
    @ApiOperation(value = "Delete Trip Detail", response = TripDetailReadDTO.class)
    public ResponseEntity<TripDetailReadDTO> deleteDetail(@PathVariable("tripId") String tripId,
                                                          @PathVariable("id") String id) {
        return ResponseEntity.ok(tripDetailServiceView.delete(id));
    }

    @PostMapping("/detail/search")
    @ApiOperation(value = "Search Trip Detail", response = Page.class)
    public ResponseEntity<Page<TripDetailReadDTO>> searchDetail(@RequestBody() TripDetailSearchCriteriaDTO filter,
                                                                @RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(tripDetailServiceView.search(filter, PageRequest.of(page, size)));
    }

    @GetMapping("/{tripId}/detail/{id}/approved")
    @ApiOperation(value = "Mark As Approved Trip Detail", response = TripDetailReadDTO.class)
    public ResponseEntity<TripDetailReadDTO> markAsApprove(@PathVariable("tripId") String tripId,
                                                           @PathVariable("id") String id) {
        return ResponseEntity.ok(tripDetailServiceView.markAsApprove(id));
    }

    @GetMapping("/{tripId}/detail/{id}/denied")
    @ApiOperation(value = "Mark As Denied Trip Detail", response = TripDetailReadDTO.class)
    public ResponseEntity<TripDetailReadDTO> markAsDenied(@PathVariable("tripId") String tripId,
                                                          @PathVariable("id") String id) {
        return ResponseEntity.ok(tripDetailServiceView.markAsDenied(id));
    }

    @GetMapping("/{tripId}/detail/{id}/cancelled")
    @ApiOperation(value = "Mark As Approved Trip Detail", response = TripDetailReadDTO.class)
    public ResponseEntity<TripDetailReadDTO> markAsCancelled(@PathVariable("tripId") String tripId,
                                                             @PathVariable("id") String id) {
        return ResponseEntity.ok(tripDetailServiceView.markAsCancelled(id));
    }
}
