package xyz.vegaone.sanctuary.dto;

public class Ambulance {

    private Long id;

    private String firstTreatment;

    private String oldDiseases;

    private String oldTreatment;

    private String otherObservations;

    private FirstCall firstCallId;

    public FirstCall getFirstCallId() {
        return firstCallId;
    }

    public void setFirstCallId(FirstCall firstCallId) {
        this.firstCallId = firstCallId;
    }

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
