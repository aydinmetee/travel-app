package tr.com.metea.travelapp.dto.trip;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tr.com.metea.travelapp.domain.TripMaster;
import tr.com.metea.travelapp.dto.trip.TripMasterReadDTO;
import tr.com.metea.travelapp.util.SearchCriteria;
import tr.com.metea.travelapp.util.SearchCriteriaOptions;

/**
 * @author mete.aydin
 * @since 27.02.2022
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class TripMasterSearchCriteriaDTO extends TripMasterReadDTO {
    public SearchCriteriaOptions<TripMaster> TripMasterSearchCriteriaFieldMapper() {
        final var searchCriteriaOptions = new SearchCriteriaOptions<TripMaster>();
        searchCriteriaOptions.add(new SearchCriteria("id", this.getId(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("crewMaster/id", this.getCrewMasterId(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("crewOnly", this.getCrewOnly(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("assigneeId", this.getAssigneeId(), SearchCriteria.SearchOperation.EQUAL));

        return searchCriteriaOptions;
    }
}
