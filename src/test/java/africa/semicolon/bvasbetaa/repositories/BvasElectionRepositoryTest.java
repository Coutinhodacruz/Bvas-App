package africa.semicolon.bvasbetaa.repositories;

import africa.semicolon.bvasbetaa.models.Election;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class BvasElectionRepositoryTest {

    private final ElectionRepository electionRepository = new BvasElectionRepository();

    private Election savedElection;

    @BeforeEach
    public void setUp(){
        Election election = builTestElection();
        savedElection = electionRepository.save(election);
    }


//
//    @DisplayName("Save Election")
//    @Test
//    public void testSaveElection(){
//
//        assertNotNull(savedElection);
//        assertNotNull(savedElection);
//    }

//
//    @DisplayName("Find Id")
//    @Test
//    public void testFindById(){
//        Voter foundVoter = voterRepository.findById(savedVoter.getId());
//        assertNotNull(foundVoter);
//    }
//
//
//    @DisplayName("Find All Voter")
//    @Test
//    public void testFindAllVoter(){
//        Voter secondVoter = new Voter();
//        Voter thirdVoter = new Voter();
//        voterRepository.save(secondVoter);
//        voterRepository.save(thirdVoter);
//
//        List<Voter> voters = voterRepository.findAll();
//        assertEquals(3, voters.size());
//        assertNotNull(voters.get(0));
//        assertNotNull(voters.get(1));
//        assertNotNull(voters.get(2));
//
//    }
//
//    @DisplayName("Delete Voter By Id")
//    @Test
//    public void testDeleteVoterById(){
//        Voter secondVoter = new Voter();
//        Voter secondSavedVoter = voterRepository.save(secondVoter);
//        List<Voter> voters = voterRepository.findAll();
//        assertEquals(2, voters.size());
//        voterRepository.deleteById(secondSavedVoter.getId());
//        voters = voterRepository.findAll();
//        assertEquals(1, voters.size());
//
//    }

    private Election builTestElection(){

        return new Election();
    }

}