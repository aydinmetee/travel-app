package tr.com.metea.travelapp.dto.trip;

import lombok.*;
import tr.com.metea.travelapp.domain.TripDetail;

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
public class TripDetailReadDTO extends TripDetailWriteDTO {
    private String id;
    private TripDetail.ParticipantStatus status;
    private Date creDate;
    private String creUser;
    private Date updDate;
    private String updUser;
}
