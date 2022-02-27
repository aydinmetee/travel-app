package tr.com.metea.travelapp.dto;

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
public class ProfileReadDTO extends ProfileWriteDTO {
    private String userId;
    private String id;
    private Date creDate;
    private String creUser;
    private Date updDate;
    private String updUser;
}
