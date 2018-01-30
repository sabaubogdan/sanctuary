package xyz.vegaone.sanctuary.ambulance;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vegaone.sanctuary.dto.Ambulance;
import xyz.vegaone.sanctuary.dto.FirstCall;
import xyz.vegaone.sanctuary.service.AmbulanceService;
import xyz.vegaone.sanctuary.service.FirstCallService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AmbulanceServiceTest {

    private static String FIRST_TREATMENT = "Medicine";
    private static String OLD_DISEASES = "Old diseases";
    private static String OLD_TREATMENT = "Old Treatment";
    private static String OTHER_OBSERVATIONS = "Patient will be sent to the hospital";
    private static String NEW_FIRST_TREATMENT = "Medicine";

    private final String PATIENT_WHAT_IS_THE_EMERGENCY = "Emergency test";
    private final String PATIENT_NAME = "Fake name";
    private final Integer PATIENT_AGE = 65;
    private final String PATIENT_ADDRESS = "Cluj, Cluj-Napoca, fake street";
    private final Long PATIENT_CONTACT_NUMBER = 4042513156L;
    private final String PATIENT_OTHER_RELEVANT_DATA = "Other info";
    private final String NEW_PATIENT_OTHER_RELEVANT_DATA = "Other new info";

    @Autowired
    private FirstCallService firstCallService;

    @Autowired
    private AmbulanceService ambulanceService;

    @Test
    public void createAmbulanceTest() {
        //given

        //when
        Ambulance savedAmbulance = buildAndSaveAmbulance();
        FirstCall savedFirstCall = buildAndSaveFistCall();

        //then
        Assert.assertNotNull("There should have been one Ambulance saved in the database", savedAmbulance);
        Assert.assertEquals("The Ambulance id should matche first call id", savedAmbulance.getId(), savedFirstCall.getId());
        Assert.assertEquals("The Ambulance first treatment should have matched", FIRST_TREATMENT, savedAmbulance.getFirstTreatment());
        Assert.assertEquals("The Ambulance old diseases should have matched", OLD_DISEASES, savedAmbulance.getOldDiseases());
        Assert.assertEquals("The Ambulance other observations should have matched", OTHER_OBSERVATIONS, savedAmbulance.getOtherObservations());
        Assert.assertEquals("The Ambulance old treatment should have matched", OLD_TREATMENT, savedAmbulance.getOldTreatment());

    }

    @Test
    public void getAmbulanceTest() {
        //given
        Ambulance savedAmbulance = buildAndSaveAmbulance();
        FirstCall savedFirstCall = buildAndSaveFistCall();

        //when
        Ambulance findAmbulance = ambulanceService.getAmbulance(savedAmbulance.getId());

        //then
        Assert.assertNotNull("There should have been one Ambulance saved in the database", findAmbulance);
        Assert.assertEquals("The Ambulance first treatment should have matched", FIRST_TREATMENT, savedAmbulance.getFirstTreatment());
        Assert.assertEquals("The Ambulance old diseases should have matched", OLD_DISEASES, savedAmbulance.getOldDiseases());
        Assert.assertEquals("The Ambulance other observations should have matched", OTHER_OBSERVATIONS, savedAmbulance.getOtherObservations());
        Assert.assertEquals("The Ambulance old treatment should have matched", OLD_TREATMENT, savedAmbulance.getOldTreatment());
    }

    @Test
    public void deleteAmbulanceTest() {
        //given
        Ambulance savedAmbulance = buildAndSaveAmbulance();
        FirstCall savedFirstCall = buildAndSaveFistCall();

        //when
        ambulanceService.deleteAmbulance(savedAmbulance.getId());
        firstCallService.deleteFirstCall(savedFirstCall.getId());

        //then
        Assert.assertNull("Ambulance should have been deleted from db", ambulanceService.getAmbulance(savedAmbulance.getId()));
    }

    @Test
    public void updateAmbulanceTest() {
        //given
        Ambulance savedAmbulance = buildAndSaveAmbulance();
        FirstCall savedFirstCall = buildAndSaveFistCall();

        //when
        savedAmbulance.setFirstTreatment(NEW_FIRST_TREATMENT);
        Ambulance updatedAmbulance = ambulanceService.updateAmbulance(savedAmbulance);

        //then
        Assert.assertNotNull("There should have been one Ambulance saved in the database", updatedAmbulance);
        Assert.assertEquals("The Ambulance new patient treamtent should have been updated", NEW_FIRST_TREATMENT, updatedAmbulance.getFirstTreatment());
    }

    private Ambulance buildAndSaveAmbulance() {
        Ambulance ambulance = new Ambulance();
        ambulance.setFirstTreatment(FIRST_TREATMENT);
        ambulance.setOldDiseases(OLD_DISEASES);
        ambulance.setOtherObservations(OTHER_OBSERVATIONS);
        ambulance.setOldTreatment(OLD_TREATMENT);
//        ambulance.setFirstCallId(buildAndSaveFistCall().getId());

        Ambulance savedAmbulance = ambulanceService.createAmbulance(ambulance);

        return savedAmbulance;
    }

    private FirstCall buildAndSaveFistCall() {

        FirstCall firstCall = new FirstCall();
        firstCall.setWhatIsTheEmergency(PATIENT_WHAT_IS_THE_EMERGENCY);
        firstCall.setPatientName(PATIENT_NAME);
        firstCall.setPatientAge(PATIENT_AGE);
        firstCall.setAddress(PATIENT_ADDRESS);
        firstCall.setContactNumber(PATIENT_CONTACT_NUMBER);
        firstCall.setOtherRelevantInformation(PATIENT_OTHER_RELEVANT_DATA);
        FirstCall savedFirstCall = firstCallService.createFirstCall(firstCall);

        return savedFirstCall;
    }
}
