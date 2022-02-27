package tr.com.metea.travelapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
@RequiredArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "crew_mst")
public class CrewMaster extends BaseEntity {
    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "code", length = 100)
    private String code;
    @Column(name = "leader_id")
    private String leaderId;
    @Column(name = "member_count")
    private BigDecimal memberCount;
    @Column(name = "description", length = 255)
    private String description;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CrewStatus status;

    public enum CrewStatus {
        ACTIVE,
        PASSIVE
    }
}
