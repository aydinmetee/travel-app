package tr.com.metea.travelapp.dto.trip;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tr.com.metea.travelapp.domain.TripDetail;
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
public class TripDetailSearchCriteriaDTO extends TripDetailReadDTO {
    public SearchCriteriaOptions<TripDetail> TripDetailSearchCriteriaFieldMapper() {
        final var searchCriteriaOptions = new SearchCriteriaOptions<TripDetail>();
        searchCriteriaOptions.add(new SearchCriteria("id", this.getId(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("tripMaster/id", this.getMasterId(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("status", this.getStatus(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("participantId", this.getParticipantId(), SearchCriteria.SearchOperation.EQUAL));

        return searchCriteriaOptions;
    }
}
