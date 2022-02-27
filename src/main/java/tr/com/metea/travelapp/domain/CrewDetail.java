package tr.com.metea.travelapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
@RequiredArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "crew_det")
public class CrewDetail extends BaseEntity {
    @Column(name = "member_id", length = 36)
    private String memberId;

    @JoinColumn(name = "master_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CrewMaster crewMaster;
}
