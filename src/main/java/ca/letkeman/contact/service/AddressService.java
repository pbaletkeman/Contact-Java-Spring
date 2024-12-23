package ca.letkeman.contact.service;

import ca.letkeman.contact.model.Address;
import ca.letkeman.contact.repository.AddressRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

  private final AddressRepository addressRepository;

  @Autowired
  public AddressService(AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
  }

  public Address createAddress(Address address) {
    return addressRepository.save(address);
  }

  public Address updateAddress(Long id, Address updatedAddress) {
    Optional<Address> existingAddress = addressRepository.findById(id);
    if (existingAddress.isPresent()) {
      Address address = existingAddress.get();
      // Update other fields as needed
      address.setCity(updatedAddress.getCity());
      address.setCountry(updatedAddress.getCountry());
      address.setContact(updatedAddress.getContact());
      address.setEmail(updatedAddress.getEmail());
      address.setPhone(updatedAddress.getPhone());
      address.setPostalCode(updatedAddress.getPostalCode());
      address.setProvince(updatedAddress.getProvince());
      address.setStreet1(updatedAddress.getStreet1());
      address.setStreet2(updatedAddress.getStreet2());
      address.setTitle(updatedAddress.getTitle());

      return addressRepository.save(address);
    }
    return null; // Handle not found case
  }

  public List<Address> getAllAddresses() {

    return addressRepository.findAll();
  }

  public Address getAddressById(Long id) {
    return addressRepository.findById(id).orElse(null);
  }

  public void deleteAddressById(Long id) {
    if (id != null) {
      addressRepository.deleteById(id);
    }
  }

  public void deleteManyAddresses(String ids) {
    if (!ids.isEmpty()) {
      addressRepository.deleteAllById(Arrays.stream(ids.split(",")).map(Long::parseLong).toList());
    }
  }

  public List<Address> getAddressByContact(Long exerciseId){
    return addressRepository.findByContactId(exerciseId);
  }
  // Other methods (e.g., deleteAddress, getAddressByContact) can be added as needed
}
