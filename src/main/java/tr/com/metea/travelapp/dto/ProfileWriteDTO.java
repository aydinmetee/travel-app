package tr.com.metea.travelapp.dto;

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
public class ProfileWriteDTO {
    private String firstName;
    private String lastName;
    private Integer age;
    private String phoneNumber;
}
