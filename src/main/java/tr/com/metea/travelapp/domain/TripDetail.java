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
@Table(name = "trip_det")
public class TripDetail extends BaseEntity {
    @JoinColumn(name = "master_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private TripMaster tripMaster;
    @Column(name = "participant_id", length = 36)
    private String participantId;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ParticipantStatus status;

    public enum ParticipantStatus {
        APPROVED,
        DENIED,
        CANCELLED,
        WAIT4APP
    }
}
