package tr.com.metea.travelapp.dto.trip;

import lombok.*;

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
public class TripDetailWriteDTO {
    private String masterId;
    private String participantId;
}
