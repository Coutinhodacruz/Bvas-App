package africa.semicolon.bvasbetaa.repositories;

import africa.semicolon.bvasbetaa.models.Gender;
import africa.semicolon.bvasbetaa.models.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasVoterRepositoryTest {
    private final VoterRepository voterRepository = new BvasVoterRepository();

    private Voter savedVoter;

    @BeforeEach
    public void setUp(){
        Voter voter = buildTestVoter();
         savedVoter = voterRepository.save(voter);

    }

    @DisplayName("Save Voter")
    @Test
    public void testSaveVoter(){

        assertNotNull(savedVoter);
        assertNotNull(savedVoter.getId());
    }


    @DisplayName("Find Id")
    @Test
    public void testFindById(){
        Voter foundVoter = voterRepository.findById(savedVoter.getId());
        assertNotNull(foundVoter);
    }


    @DisplayName("Find All Voter")
    @Test
    public void testFindAllVoter(){
        Voter secondVoter = new Voter();
        Voter thirdVoter = new Voter();
        voterRepository.save(secondVoter);
        voterRepository.save(thirdVoter);

        List<Voter> voters = voterRepository.findAll();
        assertEquals(3, voters.size());
        assertNotNull(voters.get(0));
        assertNotNull(voters.get(1));
        assertNotNull(voters.get(2));

    }

    @DisplayName("Delete Voter By Id")
    @Test
    public void testDeleteVoterById(){
        Voter secondVoter = new Voter();
        Voter secondSavedVoter = voterRepository.save(secondVoter);
        List<Voter> voters = voterRepository.findAll();
        assertEquals(2, voters.size());
        voterRepository.deleteById(secondSavedVoter.getId());
        voters = voterRepository.findAll();
        assertEquals(1, voters.size());

    }



    private Voter buildTestVoter(){
        Voter voter = new Voter();
        voter.setName("Jane Doe");
        voter.setAge(20);
        voter.setGender(Gender.FEMALE);
        return voter;
    }



}