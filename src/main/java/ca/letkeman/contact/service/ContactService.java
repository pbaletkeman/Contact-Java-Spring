package ca.letkeman.contact.service;

import ca.letkeman.contact.repository.ContactRepository;
import ca.letkeman.contact.repository.AddressRepository;
import ca.letkeman.contact.model.Contact;
import ca.letkeman.contact.model.Address;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository, AddressRepository addressRepository) {
        this.contactRepository = contactRepository;
      this.addressRepository = addressRepository;
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(Long id, Contact updatedContact) {
        return updateContact(id, updatedContact, false);
    }

    public Contact updateContact(Long id, Contact updatedExercise, boolean updateAddress) {
        Optional<Contact> existingContact = contactRepository.findById(id);
        if (existingContact.isPresent()) {
            // Update other fields as needed
            Contact contact = existingContact.get();
            contact.setFirstName(updatedExercise.getFirstName());
            contact.setLastName(updatedExercise.getLastName());
            contact.setMiddleName(updatedExercise.getMiddleName());
            if (updateAddress) {
                Address address;
                for (Long i : updatedExercise.getAddresses().stream().map(Address::getId).toList()) {
                    address = addressRepository.findById(i).orElse(null);
                    if (address != null) {
                        address.setContact(contact);
                    }
                }
            }
            return contactRepository.save(contact);
        }
        return null; // Handle not found case
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public void deleteContactById(Long id){
        contactRepository.deleteById(id);
    }

    public void deleteManyContacts(String ids){
        contactRepository.deleteAllById(Arrays.stream(ids.split(",")).map(Long::parseLong).toList());
    }

}
