package africa.semicolon.bvasbetaa.repositories;

import africa.semicolon.bvasbetaa.models.Address;
import africa.semicolon.bvasbetaa.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BvasAddressRepository implements AddressRepository{

    List<Address> votersAddress = new ArrayList<>();

    @Override
    public Address findById(String id) {
        for (Address address : votersAddress){
            boolean sameAddress = Objects.equals(address.getId(), id);
            if (sameAddress) return address;
        }
        return null;
    }

    @Override
    public List<Address> findAll() {

        return votersAddress;
    }

    @Override
    public Address save(Address address) {
        String id = AppUtils.generateId();
        address.setId(id);
        votersAddress.add(address);
        return address;
    }

    @Override
    public void deleteById(String id) {
        Address foundAddress = findById(id);
        votersAddress.remove(foundAddress);

    }
}
