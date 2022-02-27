package tr.com.metea.travelapp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tr.com.metea.travelapp.domain.Profile;
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
public class ProfileSearchCriteriaDTO extends ProfileReadDTO {
    public SearchCriteriaOptions<Profile> ProfileSearchCriteriaFieldMapper() {
        final var searchCriteriaOptions = new SearchCriteriaOptions<Profile>();
        searchCriteriaOptions.add(new SearchCriteria("id", this.getId(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("firstName", this.getFirstName(), SearchCriteria.SearchOperation.LIKE));
        searchCriteriaOptions.add(new SearchCriteria("lastName", this.getLastName(), SearchCriteria.SearchOperation.LIKE));
        searchCriteriaOptions.add(new SearchCriteria("age", this.getAge(), SearchCriteria.SearchOperation.EQUAL));
        searchCriteriaOptions.add(new SearchCriteria("phoneNumber", this.getPhoneNumber(), SearchCriteria.SearchOperation.LIKE));
        searchCriteriaOptions.add(new SearchCriteria("userId", this
                .getUserId(), SearchCriteria.SearchOperation.EQUAL));

        return searchCriteriaOptions;
    }
}
