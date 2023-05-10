package africa.semicolon.bvasbetaa.repositories;

import africa.semicolon.bvasbetaa.models.Address;
import africa.semicolon.bvasbetaa.models.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasAddressRepositoryTest {

    private final AddressRepository addressRepository = new BvasAddressRepository();

    private Address savedAddress;

    @BeforeEach
    void setUp(){
        Address address = buildTestAddress();
        savedAddress = addressRepository.save(address);
    }

    @DisplayName("Save Address")
    @Test
    public void testSaveAddress(){
        assertNotNull(savedAddress);
        assertNotNull(savedAddress.getId());
    }

    @DisplayName("Find Id")
    @Test
    public void testFindById(){
        Address foundAddress = addressRepository.findById(savedAddress.getId());
        assertNotNull(foundAddress);
    }


    @DisplayName("Find All Voter")
    @Test
    public void testFindAllVoter(){
        Address secondAddress = new Address();
        Address thirdAddress = new Address();
        addressRepository.save(secondAddress);
        addressRepository.save(thirdAddress);

        List<Address> addressList = addressRepository.findAll();
        assertEquals(3, addressList.size());
        assertNotNull(addressList.get(0));
        assertNotNull(addressList.get(1));
        assertNotNull(addressList.get(2));

    }

    @DisplayName("Delete Voter By Id")
    @Test
    public void testDeleteVoterById(){
        Address secondAddress = new Address();
        Address secondSavedAddress = addressRepository.save(secondAddress);
        List<Address> addressList = addressRepository.findAll();
        assertEquals(2, addressList.size());
        addressRepository.deleteById(secondSavedAddress.getId());
        addressList = addressRepository.findAll();
        assertEquals(1, addressList.size());

    }



    private Address buildTestAddress(){
        Address address = new Address();
        address.setStreet("Lekki");
        address.setState("Lagos");
        address.setLocalGovernmentArea("Oshodi");
        return  address;
    }

}