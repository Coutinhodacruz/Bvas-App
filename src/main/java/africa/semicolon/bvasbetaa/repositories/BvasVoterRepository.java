package africa.semicolon.bvasbetaa.repositories;

import africa.semicolon.bvasbetaa.models.Voter;
import africa.semicolon.bvasbetaa.utils.AppUtils;

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
        String id = AppUtils.generateId();
        voter.setId(id);
        voterList.add(voter);
        return voter;
    }

    @Override
    public void deleteById(String id) {
        Voter foundVoter = findById(id);
        if(foundVoter != null) voterList.remove(foundVoter);

    }


}
