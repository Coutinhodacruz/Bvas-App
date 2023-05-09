package africa.semicolon.bvasbetaa.repositories;

import africa.semicolon.bvasbetaa.models.Address;

import java.util.List;

public interface AddressRepository {
    Address findById(String id);
    List<Address> findAll();
    Address save(Address address);

    void deleteById(String id);
}
