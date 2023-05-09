package africa.semicolon.bvasbetaa.repositories;

import africa.semicolon.bvasbetaa.models.UserInformation;

import java.util.List;

public interface UserInformationRepository {
    UserInformation findById(String id);
    List<UserInformation> findAll();
    UserInformation save(UserInformation userInformation);

    void deleteById(String id);
}
