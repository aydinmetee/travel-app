package tr.com.metea.travelapp.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import tr.com.metea.travelapp.util.IdGenerator;
import tr.com.metea.travelapp.util.SessionContext;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
    @Id
    @Column(name = "ID", nullable = false, length = 36)
    private String id;

    @Column(name = "CRE_USER", nullable = false, length = 36)
    private String creUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CRE_DATE", nullable = false)
    private Date creDate;

    @Column(name = "UPD_USER", length = 36)
    private String updUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPD_DATE")
    private Date updDate;

    @PrePersist
    public void onPrePersist() {
        setId(IdGenerator.getUUID());
        this.creDate = new Date();
        this.creUser = SessionContext.getSessionData().getUserId();
    }

    @PreUpdate
    public void onPreUpdate() {
        this.updDate = new Date();
        this.updUser = SessionContext.getSessionData().getUserId();

    }

}
