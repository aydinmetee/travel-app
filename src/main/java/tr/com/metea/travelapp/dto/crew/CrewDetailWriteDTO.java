package tr.com.metea.travelapp.dto.crew;

import lombok.*;

import javax.persistence.Column;

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
public class CrewDetailWriteDTO {
    @Column(name = "master_id", length = 36)
    private String masterId;
}
