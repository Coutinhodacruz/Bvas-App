package africa.semicolon.bvasbetaa.service;

import africa.semicolon.bvasbetaa.dtos.request.VoterRegistrationRequest;
import africa.semicolon.bvasbetaa.dtos.response.VoterRegistrationResponse;

public interface VoterService {

     VoterRegistrationResponse register(VoterRegistrationRequest voterRegistrationRequest);
}
