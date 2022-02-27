package tr.com.metea.travelapp.dto.crew;

import lombok.*;

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
public class CrewMasterWriteDTO {
    private String name;
    private String code;
    private String description;
}
