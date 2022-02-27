package tr.com.metea.travelapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
@RequiredArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "trip_mst")
public class TripMaster extends BaseEntity {
    @JoinColumn(name = "crew_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CrewMaster crewMaster;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_DATE")
    private Date startDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_DATE")
    private Date endDate;
    @Column(name = "assignee_id", length = 36)
    private String assigneeId;
    @Column(name = "start_location", length = 255)
    private String startLocation;
    @Column(name = "end_location", length = 255)
    private String endLocation;
    @Type(type = "yes_no")
    @Column(name = "crew_only")
    private Boolean crewOnly;
}
