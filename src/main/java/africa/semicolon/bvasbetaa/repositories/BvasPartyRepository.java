package africa.semicolon.bvasbetaa.repositories;

import africa.semicolon.bvasbetaa.models.Party;
import africa.semicolon.bvasbetaa.models.UserInformation;
import africa.semicolon.bvasbetaa.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BvasPartyRepository implements PartyRepository{
    List<Party> politicalParties = new ArrayList<>();
    private final UserInformationRepository userInformationRepository = new BvasUserInformationRepository();

    @Override
    public Party findById(String id) {
        Party foundParty = null;
        for(Party party : politicalParties) {
            if (party.getId().equals(id)) foundParty = party;
        }
            if (foundParty != null) {
                String userInformationId = AppUtils.getUserUserInformation(foundParty.getId());
                UserInformation userInformation = userInformationRepository.findById(userInformationId);
                foundParty.setUserInformation(userInformation);

        }
//        for(Party party : politicalParties){
//            boolean sameParty = Objects.equals(party.getId(), id);
//            if(sameParty) return party;
//        }
//        return null;
        return foundParty;
    }

    @Override
    public List<Party> findAll() {
        List<Party> foundPoliticalParties = new ArrayList<>();
        for (Party party : politicalParties){
            String userInformationId = AppUtils.getUserUserInformation(party.getId());
            if (userInformationId != null) {

                UserInformation foundUserInformation = userInformationRepository.findById(userInformationId);
                party.setUserInformation(foundUserInformation);
            }
        }
        return politicalParties;
    }

    @Override
    public Party save(Party party) {
        party.setId(AppUtils.generateId());
        boolean isPartyWithUserInformation = party.getUserInformation() != null;
        if (isPartyWithUserInformation) saveUserInformation(party);
        politicalParties.add(party);

        return party;
    }

    private void saveUserInformation(Party party){
        UserInformation savedUserInformation = userInformationRepository.save(party.getUserInformation());
        String partyId = party.getId();
        String userInformationId = savedUserInformation.getId();
        AppUtils.linkUserToUserInformation(partyId, userInformationId);
    }

    @Override
    public void deleteById(String id) {
        var foundParty = findById(id);
        if (foundParty != null) politicalParties.remove(foundParty);
    }
}