package tr.com.metea.travelapp.dto.crew;

import lombok.*;
import tr.com.metea.travelapp.domain.CrewDetail;
import tr.com.metea.travelapp.dto.crew.CrewDetailReadDTO;
import tr.com.metea.travelapp.util.SearchCriteria;
import tr.com.metea.travelapp.util.SearchCriteriaOptions;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class CrewDetailSearchCriteriaDTO extends CrewDetailReadDTO {
    public SearchCriteriaOptions<CrewDetail> CrewDetailSearchCriteriaFieldMapper() {
        final var searchCriteriaOptions = new SearchCriteriaOptions<CrewDetail>();
        searchCriteriaOptions.add(new SearchCriteria("id", this.getId(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("masterId", this.getMasterId(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("memberId", this.getMemberId(), SearchCriteria.SearchOperation.EQUAL));

        return searchCriteriaOptions;
    }
}
