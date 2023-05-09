package africa.semicolon.bvasbetaa.repositories;

import africa.semicolon.bvasbetaa.models.Party;

import java.util.List;

public interface PartyRepository {
    Party findById(String id);
    List<Party> findAll();
   Party save(Party party);

    void deleteById(String id);
}
