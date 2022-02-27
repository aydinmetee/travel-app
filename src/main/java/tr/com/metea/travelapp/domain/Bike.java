package tr.com.metea.travelapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author mete.aydin
 * @since 26.02.2022
 */
@RequiredArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
@Table(name = "bike")
public class Bike extends BaseEntity {
    @Column(name = "brand", length = 100)
    private String brand;
    @Column(name = "model", length = 100)
    private String model;
    @Column(name = "owner_id")
    private String ownerId;
}
