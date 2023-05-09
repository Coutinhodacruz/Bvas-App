package africa.semicolon.bvasbetaa.repositories;
import africa.semicolon.bvasbetaa.models.Voter;

import java.util.List;

public interface VoterRepository {

    Voter findById(String id);
    List<Voter> findAll();
    Voter save(Voter voter);

    void deleteById(String id);

}
