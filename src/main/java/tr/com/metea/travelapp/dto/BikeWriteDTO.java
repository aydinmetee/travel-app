package tr.com.metea.travelapp.dto;

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
public class BikeWriteDTO {
    private String brand;
    private String model;
}
