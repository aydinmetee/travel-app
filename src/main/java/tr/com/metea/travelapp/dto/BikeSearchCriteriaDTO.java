package tr.com.metea.travelapp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tr.com.metea.travelapp.domain.Bike;
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
public class BikeSearchCriteriaDTO extends BikeReadDTO {
    public SearchCriteriaOptions<Bike> BikeSearchCriteriaFieldMapper() {
        final var searchCriteriaOptions = new SearchCriteriaOptions<Bike>();
        searchCriteriaOptions.add(new SearchCriteria("id", this.getId(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("brand", this.getBrand(), SearchCriteria.SearchOperation.LIKE));
        searchCriteriaOptions.add(new SearchCriteria("model", this.getModel(), SearchCriteria.SearchOperation.LIKE));
        searchCriteriaOptions.add(new SearchCriteria("ownerId", this.getOwnerId(), SearchCriteria.SearchOperation.EQUAL));

        return searchCriteriaOptions;
    }
}
