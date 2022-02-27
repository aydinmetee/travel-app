package tr.com.metea.travelapp.dto.crew;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tr.com.metea.travelapp.domain.CrewMaster;
import tr.com.metea.travelapp.dto.crew.CrewMasterReadDTO;
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
public class CrewMasterSearchCriteriaDTO extends CrewMasterReadDTO {
    public SearchCriteriaOptions<CrewMaster> CrewMasterSearchCriteriaFieldMapper() {
        final var searchCriteriaOptions = new SearchCriteriaOptions<CrewMaster>();
        searchCriteriaOptions.add(new SearchCriteria("id", this.getId(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("name", this.getName(), SearchCriteria.SearchOperation.LIKE));
        searchCriteriaOptions.add(new SearchCriteria("code", this.getCode(), SearchCriteria.SearchOperation.LIKE));
        searchCriteriaOptions.add(new SearchCriteria("leaderId", this.getLeaderId(), SearchCriteria.SearchOperation.EQUAL));

        return searchCriteriaOptions;
    }
}
