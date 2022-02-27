package tr.com.metea.travelapp.dto.trip;

import lombok.*;

import java.util.Date;

/**
 * @author mete.aydin
 * @since 27.02.2022
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TripMasterWriteDTO {
    private String crewMasterId;
    private Date startDate;
    private Date endDate;
    private String startLocation;
    private String endLocation;
    private Boolean crewOnly;
}
