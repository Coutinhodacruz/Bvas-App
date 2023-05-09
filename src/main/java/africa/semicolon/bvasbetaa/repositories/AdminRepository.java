package africa.semicolon.bvasbetaa.repositories;

import africa.semicolon.bvasbetaa.models.Admin;

import java.util.List;

public interface AdminRepository {

    Admin findById(String id);
    List<Admin> findAll();
    Admin save(Admin admin);

    void deleteById(String id);



}
