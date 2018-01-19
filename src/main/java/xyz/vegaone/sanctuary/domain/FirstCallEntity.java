package xyz.vegaone.sanctuary.domain;

import javax.persistence.*;

@Entity
@Table(name = "first_call")
public class FirstCallEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "what_is_the_emergency")
    private String whatIsTheEmergency;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "patient_age")
    private Integer patientAge;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_number")
    private Long contactNumber;

    @Column(name = "other_relevant_information")
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
