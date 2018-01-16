package xyz.vegaone.sanctuary.firstcall;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vegaone.sanctuary.dto.FirstCall;
import xyz.vegaone.sanctuary.service.FirstCallService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FirstCallServiceTest {
    private final String PATIENT_WHAT_IS_THE_EMERGENCY = "Emergency test";
    private final String PATIENT_NAME = "Fake name";
    private final Integer PATIENT_AGE = 65;
    private final String PATIENT_ADDRESS = "Cluj, Cluj-Napoca, fake street";
    private final Long PATIENT_CONTACT_NUMBER = 4042513156L;
    private final String PATIENT_OTHER_RELEVANT_DATA = "Other info";
    private final String NEW_PATIENT_OTHER_RELEVANT_DATA = "Other new info";


    @Autowired
    private FirstCallService firstCallService;

    @Test
    public void createFirstCallTest() {
        //given
        FirstCall firstCall = new FirstCall();
        firstCall.setWhatIsTheEmergency(PATIENT_WHAT_IS_THE_EMERGENCY);
        firstCall.setPatientName(PATIENT_NAME);
        firstCall.setPatientAge(PATIENT_AGE);
        firstCall.setAddress(PATIENT_ADDRESS);
        firstCall.setContactNumber(PATIENT_CONTACT_NUMBER);
        firstCall.setOtherRelevantInformation(PATIENT_OTHER_RELEVANT_DATA);

        //when
        FirstCall savedFirstCall = firstCallService.createFirstCall(firstCall);

        //then
        Assert.assertNotNull("There should have been one firstCall saved in the database", savedFirstCall);
        Assert.assertEquals("The first call emergency should have matched", PATIENT_WHAT_IS_THE_EMERGENCY, savedFirstCall.getWhatIsTheEmergency());
        Assert.assertEquals("The first call patient name should have matched", PATIENT_NAME, savedFirstCall.getPatientName());
        Assert.assertEquals("The first call patient age should have matched", PATIENT_AGE, savedFirstCall.getPatientAge());
        Assert.assertEquals("The first call patient address should have matched", PATIENT_ADDRESS, savedFirstCall.getAddress());
        Assert.assertEquals("The first call contact number should have matched", PATIENT_CONTACT_NUMBER, savedFirstCall.getContactNumber());
        Assert.assertEquals("The first call other info should have matched", PATIENT_OTHER_RELEVANT_DATA, savedFirstCall.getOtherRelevantInformation());
    }

    @Test
    public void getFirstCall() {
        //given
        FirstCall firstCall = new FirstCall();
        firstCall.setWhatIsTheEmergency(PATIENT_WHAT_IS_THE_EMERGENCY);
        firstCall.setPatientName(PATIENT_NAME);
        firstCall.setPatientAge(PATIENT_AGE);
        firstCall.setAddress(PATIENT_ADDRESS);
        firstCall.setContactNumber(PATIENT_CONTACT_NUMBER);
        firstCall.setOtherRelevantInformation(PATIENT_OTHER_RELEVANT_DATA);
        FirstCall savedFirstCall = firstCallService.createFirstCall(firstCall);

        //when
        FirstCall findFirstCall = firstCallService.getFirstCall(savedFirstCall.getId());

        //then
        Assert.assertNotNull("There should have been one firstCall saved in the database", findFirstCall);
        Assert.assertEquals("The first call emergency should have matched", PATIENT_WHAT_IS_THE_EMERGENCY, savedFirstCall.getWhatIsTheEmergency());
        Assert.assertEquals("The first call patient name should have matched", PATIENT_NAME, savedFirstCall.getPatientName());
        Assert.assertEquals("The first call patient age should have matched", PATIENT_AGE, savedFirstCall.getPatientAge());
        Assert.assertEquals("The first call patient address should have matched", PATIENT_ADDRESS, savedFirstCall.getAddress());
        Assert.assertEquals("The first call contact number should have matched", PATIENT_CONTACT_NUMBER, savedFirstCall.getContactNumber());
        Assert.assertEquals("The first call other info should have matched", PATIENT_OTHER_RELEVANT_DATA, savedFirstCall.getOtherRelevantInformation());
    }

    @Test
    public void deleteFirstCall() {
        //given
        FirstCall firstCall = new FirstCall();
        firstCall.setWhatIsTheEmergency(PATIENT_WHAT_IS_THE_EMERGENCY);
        firstCall.setPatientName(PATIENT_NAME);
        firstCall.setPatientAge(PATIENT_AGE);
        firstCall.setAddress(PATIENT_ADDRESS);
        firstCall.setContactNumber(PATIENT_CONTACT_NUMBER);
        firstCall.setOtherRelevantInformation(PATIENT_OTHER_RELEVANT_DATA);
        FirstCall savedFirstCall = firstCallService.createFirstCall(firstCall);

        //when
        firstCallService.deleteFirstCall(savedFirstCall.getId());

        //then
        Assert.assertNull("First call should have been deleted from db", firstCallService.getFirstCall(savedFirstCall.getId()));
    }

    @Test
    public void updateFirstCall() {
        //given
        FirstCall firstCall = new FirstCall();
        firstCall.setWhatIsTheEmergency(PATIENT_WHAT_IS_THE_EMERGENCY);
        firstCall.setPatientName(PATIENT_NAME);
        firstCall.setPatientAge(PATIENT_AGE);
        firstCall.setAddress(PATIENT_ADDRESS);
        firstCall.setContactNumber(PATIENT_CONTACT_NUMBER);
        firstCall.setOtherRelevantInformation(PATIENT_OTHER_RELEVANT_DATA);
        FirstCall savedFirstCall = firstCallService.createFirstCall(firstCall);

        //when
        savedFirstCall.setOtherRelevantInformation(NEW_PATIENT_OTHER_RELEVANT_DATA);
        FirstCall updateFirstCall = firstCallService.updateFirstCall(savedFirstCall);

        //then
        Assert.assertNotNull("There should have been one firstCall saved in the database", updateFirstCall);
        Assert.assertEquals("The first call other info should have been updated", NEW_PATIENT_OTHER_RELEVANT_DATA, updateFirstCall.getOtherRelevantInformation());

    }

}
