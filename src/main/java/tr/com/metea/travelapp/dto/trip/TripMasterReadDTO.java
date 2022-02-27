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
public class TripMasterReadDTO extends TripMasterWriteDTO {
    private String assigneeId;
    private String id;
    private Date creDate;
    private String creUser;
    private Date updDate;
    private String updUser;

}
