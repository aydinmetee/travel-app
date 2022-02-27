package tr.com.metea.travelapp.dto.crew;

import lombok.*;

import java.util.Date;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CrewDetailReadDTO extends CrewDetailWriteDTO {
    private String id;
    private String memberId;
    private Date creDate;
    private String creUser;
    private Date updDate;
    private String updUser;
}
