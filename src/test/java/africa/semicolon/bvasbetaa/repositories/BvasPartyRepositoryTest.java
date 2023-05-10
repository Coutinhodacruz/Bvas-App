package africa.semicolon.bvasbetaa.repositories;

import africa.semicolon.bvasbetaa.models.Party;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasPartyRepositoryTest {

    private final PartyRepository partyRepository = new BvasPartyRepository();

    private Party savedParty;

    @BeforeEach
    void setUp() {
        Party party = buildTestParty();
        savedParty = partyRepository.save(party);
    }

    @DisplayName("Save Party")
    @Test
    public void testSaveParty(){

        assertNotNull(savedParty);
        assertNotNull(savedParty.getId());
    }


    @DisplayName("Find Id")
    @Test
    public void testFindById(){
       Party foundVoter = partyRepository.findById(savedParty.getId());
       assertNotNull(foundVoter);
    }

//
    @DisplayName("Find All Party")
    @Test
    public void testFindAllParty(){
        Party secondParty = new Party();
        Party thirdParty = new Party();
        partyRepository.save(secondParty);
        partyRepository.save(thirdParty);

        List<Party> listOfParty = partyRepository.findAll();
        assertEquals(3, listOfParty.size());
        assertNotNull(listOfParty.get(0));
        assertNotNull(listOfParty.get(1));
        assertNotNull(listOfParty.get(2));

    }
//
    @DisplayName("Delete Party By Id")
    @Test
    public void testDeleteVoterById(){
        Party secondParty = new Party();
        Party secondSavedParty = partyRepository.save(secondParty);
        List<Party> partyList = partyRepository.findAll();
        assertEquals(2, partyList.size());
        partyRepository.deleteById(secondSavedParty.getId());
        partyList = partyRepository.findAll();
        assertEquals(1, partyList.size());

    }

    private Party buildTestParty(){
        Party party = new Party();
        party.setId("1");
        return party;
    }
}