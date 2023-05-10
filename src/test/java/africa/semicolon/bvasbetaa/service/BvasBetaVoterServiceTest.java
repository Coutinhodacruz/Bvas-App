package africa.semicolon.bvasbetaa.service;

import africa.semicolon.bvasbetaa.dtos.request.VoterRegistrationRequest;
import africa.semicolon.bvasbetaa.dtos.response.VoterRegistrationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BvasBetaVoterServiceTest {

    private final VoterService voterService = new BvasBetaVoterService();

    @BeforeEach
    void setUp() {
    }

    @Test
    void registerTest(){

        VoterRegistrationRequest registrationRequest = new VoterRegistrationRequest();
        registrationRequest.setAge(20);
        registrationRequest.setName("Sheriff");
        registrationRequest.setLga("townHall");
        registrationRequest.setGender("OTHERS");
        registrationRequest.setUserName("vawulence123@gmail.com;");
        registrationRequest.setPassword("idan123");
        registrationRequest.setState("IdanNation");
        registrationRequest.setTown("Sabo");
        registrationRequest.setStreet("Iyana Idan");
        registrationRequest.setHouseNmumber("111");

         VoterRegistrationResponse registrationResponse = voterService.register(registrationRequest);

         assertNotNull(registrationResponse);
         assertNotNull(registrationResponse.getVotersIdentificationNumber());

    }
}