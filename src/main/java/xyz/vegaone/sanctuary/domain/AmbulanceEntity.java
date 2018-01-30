package xyz.vegaone.sanctuary.domain;

import javax.persistence.*;

@Entity
@Table(name = "ambulance")
public class AmbulanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_treatment")
    private String firstTreatment;

    @Column(name = "old_diseases")
    private String oldDiseases;

    @Column(name = "old_treatment")
    private String oldTreatment;

    @Column(name = "other_observations")
    private String otherObservations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstTreatment() {
        return firstTreatment;
    }

    public void setFirstTreatment(String firstTreatment) {
        this.firstTreatment = firstTreatment;
    }

    public String getOldDiseases() {
        return oldDiseases;
    }

    public void setOldDiseases(String oldDiseases) {
        this.oldDiseases = oldDiseases;
    }

    public String getOldTreatment() {
        return oldTreatment;
    }

    public void setOldTreatment(String oldTreatment) {
        this.oldTreatment = oldTreatment;
    }

    public String getOtherObservations() {
        return otherObservations;
    }

    public void setOtherObservations(String otherObservations) {
        this.otherObservations = otherObservations;
    }
}
