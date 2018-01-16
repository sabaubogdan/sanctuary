package xyz.vegaone.sanctuary.dto;

public class FirstCall {

    private Long id;

    private String whatIsTheEmergency;

    private String patientName;

    private Integer patientAge;

    private String address;

    private Long contactNumber;

    private String otherRelevantInformation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWhatIsTheEmergency() {
        return whatIsTheEmergency;
    }

    public void setWhatIsTheEmergency(String whatIsTheEmergency) {
        this.whatIsTheEmergency = whatIsTheEmergency;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getOtherRelevantInformation() {
        return otherRelevantInformation;
    }

    public void setOtherRelevantInformation(String otherRelevantInformation) {
        this.otherRelevantInformation = otherRelevantInformation;
    }
}
