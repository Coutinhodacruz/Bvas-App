package africa.semicolon.bvasbetaa.repositories;

import africa.semicolon.bvasbetaa.models.Voter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BvasVoterRepository implements VoterRepository{
    List<Voter> voterList = new ArrayList<>();

    @Override
    public Voter findById(String id) {
        for (Voter voter : voterList){
            boolean idMatches = Objects.equals(voter.getId(), id);
            if (idMatches) return voter;
        }
        return null;
    }

    @Override
    public List<Voter> findAll() {
        return voterList;
    }

    @Override
    public Voter save(Voter voter) {
        voterList.add(voter);
        return voter;
    }

    @Override
    public void deleteById(String id) {
        Voter voter = findById(id);
        voterList.remove(voter);

    }
}
