package tr.com.metea.travelapp.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.metea.travelapp.dto.BikeReadDTO;
import tr.com.metea.travelapp.dto.BikeSearchCriteriaDTO;
import tr.com.metea.travelapp.dto.BikeWriteDTO;
import tr.com.metea.travelapp.serviceview.BikeServiceView;

import javax.validation.Valid;

/**
 * @author mete.aydin
 * @since 27.02.2022
 */
@RestController
@RequestMapping("/bike")
@RequiredArgsConstructor
@Api(value = "/bike")
public class BikeController {
    private final BikeServiceView bikeServiceView;

    @PostMapping
    @ApiOperation(value = "Create Bike", response = BikeReadDTO.class)
    public ResponseEntity<BikeReadDTO> create(@Valid @RequestBody BikeWriteDTO bikeWriteDTO) {
        return ResponseEntity.ok(bikeServiceView.save(bikeWriteDTO));
    }

    @PutMapping("/{bikeId}")
    @ApiOperation(value = "Update Bike", response = BikeReadDTO.class)
    public ResponseEntity<BikeReadDTO> update(@Valid @RequestBody BikeWriteDTO bikeWriteDTO,
                                              @PathVariable("bikeId") String bikeId) {
        return ResponseEntity.ok(bikeServiceView.update(bikeId, bikeWriteDTO));
    }

    @GetMapping("/{bikeId}")
    @ApiOperation(value = "Get Bike", response = BikeReadDTO.class)
    public ResponseEntity<BikeReadDTO> getById(@PathVariable("bikeId") String bikeId) {
        return ResponseEntity.ok(bikeServiceView.getById(bikeId));
    }

    @DeleteMapping("/{bikeId}")
    @ApiOperation(value = "Delete Bike", response = BikeReadDTO.class)
    public ResponseEntity<BikeReadDTO> delete(@PathVariable("bikeId") String bikeId) {
        return ResponseEntity.ok(bikeServiceView.delete(bikeId));
    }

    @PostMapping("/search")
    @ApiOperation(value = "Search Bike", response = Page.class)
    public ResponseEntity<Page<BikeReadDTO>> search(@RequestBody() BikeSearchCriteriaDTO filter,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(bikeServiceView.search(filter, PageRequest.of(page, size)));
    }
}
